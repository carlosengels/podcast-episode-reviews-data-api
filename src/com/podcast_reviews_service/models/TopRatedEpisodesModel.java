package com.podcast_reviews_service.models;

import com.podcast_reviews_service.dynamodb.models.Episode;

import java.util.List;
import java.util.Objects;

public class TopRatedEpisodesModel {
    private List<Episode> topRatedEpisodes;

    public TopRatedEpisodesModel() {
    }

    // *** Builder Pattern ***
    public TopRatedEpisodesModel(Builder builder) {
        this.topRatedEpisodes = builder.topRatedEpisodes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Episode> topRatedEpisodes;

        public Builder withTopRatedEpisodes(List<Episode> topRatedEpisodes) {
            this.topRatedEpisodes = topRatedEpisodes;
            return this;
        }

        public TopRatedEpisodesModel build() {
            return new TopRatedEpisodesModel(this);
        }
    }

    public List<Episode> getTopRatedEpisodes() {
        return topRatedEpisodes;
    }

    public void setTopRatedEpisodes(List<Episode> topRatedEpisodes) {
        this.topRatedEpisodes = topRatedEpisodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopRatedEpisodesModel)) return false;
        TopRatedEpisodesModel that = (TopRatedEpisodesModel) o;
        return getTopRatedEpisodes().equals(that.getTopRatedEpisodes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopRatedEpisodes());
    }

    @Override
    public String toString() {
        return "TopRatedEpisodesModel{" +
                "topRatedEpisodes=" + topRatedEpisodes +
                '}';
    }
}
