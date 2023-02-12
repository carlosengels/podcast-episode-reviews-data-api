package com.podcast_reviews_service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.podcast_reviews_service.converter.ModelConverter;
import com.podcast_reviews_service.dynamodb.EpisodeDao;
import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.models.EpisodeModel;
import com.podcast_reviews_service.models.requests.AddEpisodeRequest;
import com.podcast_reviews_service.models.results.AddEpisodeResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddEpisodeActivity implements RequestHandler<AddEpisodeRequest, AddEpisodeResult> {

    private final Logger logger = LogManager.getLogger();
    private final EpisodeDao episodeDao;

    public AddEpisodeActivity() {
        this.episodeDao = new EpisodeDao();
    }

    public AddEpisodeActivity(EpisodeDao episodeDao) {
        this.episodeDao = episodeDao;
    }

    /**
     * Handles the incoming request by persisting a new episode with
     * the provided episode name, episode number and podcast name.
     * @param addEpisodeRequest - request object containing the episode name, nr and podcast name.
     * @return - AddEpisodeResult result object contain the API defined.
     */
    @Override
    public AddEpisodeResult handleRequest(AddEpisodeRequest addEpisodeRequest, Context context) {
        logger.info("Received AddEpisodeRequest {}" + addEpisodeRequest.toString());

        Episode episode = episodeDao.saveEpisode(
                addEpisodeRequest.getPodcast(), addEpisodeRequest.getName(), addEpisodeRequest.getEpisodeNr());

        EpisodeModel episodeModel = new ModelConverter().toEpisodeModel(episode);

        return AddEpisodeResult.builder().withEpisode(episodeModel).build();
    }
}
