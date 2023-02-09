package com.podcast_reviews_service.models.results;

import com.podcast_reviews_service.models.EpisodeModel;

public class AddEpisodeResult {

    private EpisodeModel episodeModel;

    public EpisodeModel getEpisode() {
        return episodeModel;
    }

    public void setEpisode(EpisodeModel episode) {
        this.episodeModel = episode;
    }

    // *** Builder Pattern ***
    public AddEpisodeResult(Builder builder) {
        this.episodeModel = builder.episode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private EpisodeModel episode;

        public Builder withEpisode(EpisodeModel episode) {
            this.episode = episode;
            return this;
        }

        public AddEpisodeResult build() {
            return new AddEpisodeResult(this);
        }
    }

}
