package com.podcast_reviews_service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.podcast_reviews_service.converter.ModelConverter;
import com.podcast_reviews_service.dynamodb.EpisodeDao;
import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.models.TopRatedEpisodesModel;
import com.podcast_reviews_service.models.requests.GetTopRatedEpisodesRequest;
import com.podcast_reviews_service.models.results.GetTopRatedEpisodesResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetTopRatedEpisodesActivity implements RequestHandler<GetTopRatedEpisodesRequest, GetTopRatedEpisodesResult> {
    private final Logger logger = LogManager.getLogger();
    private final EpisodeDao episodeDao;

    public GetTopRatedEpisodesActivity() {
        this.episodeDao = new EpisodeDao();
    }

    public GetTopRatedEpisodesActivity(EpisodeDao episodeDao) {
        this.episodeDao = episodeDao;
    }


    @Override
    public GetTopRatedEpisodesResult handleRequest(GetTopRatedEpisodesRequest getTopRatedEpisodesRequest, Context context) {
        logger.info("Received GetTopRatedReviewRequest" + getTopRatedEpisodesRequest);
        List<Episode> topRatedEpisodes = episodeDao.getTopRatedEpisodesReviews();

        TopRatedEpisodesModel topRatedEpisodesModel = new ModelConverter().toTopRatedEpisodesModel(topRatedEpisodes);

        return GetTopRatedEpisodesResult.builder().withTopRatedEpisodes(topRatedEpisodesModel).build();
    }
}
