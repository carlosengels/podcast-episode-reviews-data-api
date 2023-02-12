package com.podcast_reviews_service.models.results;

import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.models.EpisodeModel;

public class GetEpisodeResult {

    private EpisodeModel episodeModel;


    // *** Builder Pattern ***
    public GetEpisodeResult(Builder builder) {
        this.episodeModel = builder.episodeModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private EpisodeModel episodeModel;

        public Builder withEpisodeModel(EpisodeModel episodeModel) {
            this.episodeModel = episodeModel;
            return this;
        }

        public GetEpisodeResult build() {
            return new GetEpisodeResult(this);
        }
    }

    public EpisodeModel getEpisodeModel() {
        return episodeModel;
    }

    public void setEpisodeModel(EpisodeModel episodeModel) {
        this.episodeModel = episodeModel;
    }
}
