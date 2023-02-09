package com.podcast_reviews_service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.podcast_reviews_service.converter.ModelConverter;
import com.podcast_reviews_service.dynamodb.ReviewDao;
import com.podcast_reviews_service.dynamodb.models.Review;
import com.podcast_reviews_service.models.ReviewModel;
import com.podcast_reviews_service.models.requests.AddReviewRequest;
import com.podcast_reviews_service.models.results.AddReviewResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddReviewActivity implements RequestHandler<AddReviewRequest, AddReviewResult> {

    private final Logger logger = LogManager.getLogger();

    private final ReviewDao reviewDao;

    public AddReviewActivity() {
        this.reviewDao = new ReviewDao();
    }

    public AddReviewActivity(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public AddReviewResult handleRequest(AddReviewRequest addReviewRequest, Context context) {
        logger.info("Received AddReviewRequest " + addReviewRequest);

        Review review = reviewDao.saveReview(
                addReviewRequest.getReviewTitle(), addReviewRequest.getRating(), addReviewRequest.getPostedBy(),
                addReviewRequest.getComment(), addReviewRequest.getEpisodeId());

        ReviewModel reviewModel = new ModelConverter().toReviewModel(review);

        return AddReviewResult.builder().withReviewModel(reviewModel).build();
    }
}
