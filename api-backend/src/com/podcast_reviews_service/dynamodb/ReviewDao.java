package com.podcast_reviews_service.dynamodb;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.podcast_reviews_service.dynamodb.models.Review;
import com.podcast_reviews_service.exceptions.EpisodeNotFoundException;
import com.podcast_reviews_service.utils.PodcastReviewsUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Access data for Review to represent model in DynamoDB
 */

public class ReviewDao {
    private final Logger logger = LogManager.getLogger();
    private final DynamoDBMapper dynamoDBMapper;

    public ReviewDao() {
        this.dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build());
    }

    public ReviewDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    /**
     * Scan entire Reviews table to retrieve all reviews that match a given episodeId
     * @param episodeId - auto-generated episode Id
     * @return - List of reviews
     */
    public List<Review> getReviews(String episodeId) {
        Review review = new Review();
        review.setEpisodeId(episodeId);
        DynamoDBQueryExpression<Review> queryExpression = new DynamoDBQueryExpression<Review>()
                .withHashKeyValues(review);

        List<Review> reviews = this.dynamoDBMapper.query(Review.class, queryExpression);
        return reviews;
    }

    /**
     * Adds a new review and updates the avgRating for the corresponding episode
     */

    //TODO Implement updating of episodes avgRating, everytime a new Review is added.
    public Review saveReview(String reviewTitle, int rating, String postedBy, String comment, String episodeID) {
        Review review = new Review();

        if (episodeID != null && !episodeID.isBlank()) {
            //Random ID with title + postedBy + random String
            review.setReviewId(reviewTitle.charAt(0) + postedBy.charAt(0) + PodcastReviewsUtils.generateRandomID());
            review.setReviewTitle(reviewTitle);
            review.setRating(rating);
            review.setPostedBy(postedBy);
            review.setComment(comment);
            review.setEpisodeId(episodeID);
            dynamoDBMapper.save(review);
            logger.info("Added new Review to table" + review);
            return review;
        } else throw new EpisodeNotFoundException("Episode not found while trying to create a review for it");
    }
}
