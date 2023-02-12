package com.podcast_reviews_service.dynamodb;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.exceptions.DuplicateEpisodeException;
import com.podcast_reviews_service.utils.PodcastReviewsUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Accesses data for an episode to represent the model in DynamoDB.
 */

public class EpisodeDao {

    private final Logger logger = LogManager.getLogger();
    private final DynamoDBMapper dynamoDBMapper;


    public EpisodeDao() {
        this.dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).withRegion(Regions.US_WEST_2).build());
    }


    public Episode getEpisode(String podcast, int episodeNr) {
        Episode searchObject = new Episode();
        searchObject.setPodcast(podcast);
        searchObject.setEpisodeNr(episodeNr);
        Episode episode = dynamoDBMapper.load(searchObject);
//        if (episode == null) {
//            throw new EpisodeNotFoundException("Could not find episode of " + podcast + " nr." + episodeNr);
//        }
        logger.info("Retrieved following episode from table: " + episode);
        return episode;
    }


    public Episode saveEpisode(String podcast, String name, int episodeNr) {
        Episode episode = new Episode();

        //Check if episode already exists, if so return an DuplicateEpisodeException
        //We initialize average rating at 0 since no reviews have been submitted
        if (getEpisode(podcast, episodeNr) == null) {
            episode.setPodcast(podcast);
            episode.setName(name);
            episode.setEpisodeNr(episodeNr);
            episode.setEpisodeId(podcast.charAt(0) + name.charAt(0) + PodcastReviewsUtils.generateRandomID());
            episode.setAvgRating(0);
            episode.setReviews(new ArrayList<>());
            dynamoDBMapper.save(episode);
            logger.info("Added new episode to table" + episode.toString());
            return episode;
        } else
            throw new DuplicateEpisodeException("The episode that you are trying to add seems to already exist.");
        }

    public List<Episode> getTopRatedEpisodesReviews() {
        DynamoDBQueryExpression<Episode> queryExpression = new DynamoDBQueryExpression<Episode>()
                .withIndexName("TopRatedEpisodesIndex")
                .withScanIndexForward(true)
                .withConsistentRead(false)
                .withLimit(10);

        List<Episode> topRatedEpisodes = this.dynamoDBMapper.query(Episode.class, queryExpression);


        return topRatedEpisodes;
    }
    }
