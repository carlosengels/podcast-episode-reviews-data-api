package com.podcast_reviews_service.activity;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.podcast_reviews_service.converter.ModelConverter;
import com.podcast_reviews_service.dynamodb.EpisodeDao;
import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.models.EpisodeModel;
import com.podcast_reviews_service.models.requests.GetEpisodeRequest;
import com.podcast_reviews_service.models.results.GetEpisodeResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GetEpisodeActivity implements RequestHandler<GetEpisodeRequest, GetEpisodeResult> {
    private final Logger logger = LogManager.getLogger();
    private final EpisodeDao episodeDao;

    public GetEpisodeActivity() {
        this.episodeDao = new EpisodeDao();
    }
    public GetEpisodeActivity(EpisodeDao episodeDao) {
        this.episodeDao = episodeDao;
    }



    @Override
    public GetEpisodeResult handleRequest(GetEpisodeRequest getEpisodeRequest, Context context) {
        logger.info("Received GetEpisodeRequest {}" + getEpisodeRequest.toString());
        Episode episode = episodeDao.getEpisode(getEpisodeRequest.getPodcast(), getEpisodeRequest.getEpisodeNr());

        EpisodeModel episodeModel = new ModelConverter().toEpisodeModel(episode);

        return GetEpisodeResult.builder().withEpisodeModel(episodeModel).build();
    }
}


