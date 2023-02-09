package com.podcast_reviews_service.models.results;

import com.podcast_reviews_service.models.TopRatedEpisodesModel;

public class GetTopRatedEpisodesResult {

    private TopRatedEpisodesModel topRatedEpisodesModel;

    // *** Builder Pattern ***
    public GetTopRatedEpisodesResult(Builder builder) {
        this.topRatedEpisodesModel = builder.topRatedEpisodesModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private TopRatedEpisodesModel topRatedEpisodesModel;

        public Builder withTopRatedEpisodes(TopRatedEpisodesModel topRatedEpisodes) {
            this.topRatedEpisodesModel = topRatedEpisodes;
            return this;
        }

        public GetTopRatedEpisodesResult build() {
            return new GetTopRatedEpisodesResult(this);
        }

    }
}
