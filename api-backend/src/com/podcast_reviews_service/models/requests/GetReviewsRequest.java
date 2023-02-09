package com.podcast_reviews_service.models.requests;

import java.util.Objects;

public class GetReviewsRequest {
    private String episodeId;

    // *** Constructors ***
    public GetReviewsRequest() {
    }

    public GetReviewsRequest(String episodeId) {
        this.episodeId = episodeId;
    }

    // *** Builder Pattern
    public GetReviewsRequest(Builder builder) {
        this.episodeId = builder.episodeId;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String episodeId;

        private Builder() {
        }

        public Builder withEpisodeID(String episodeId) {
            this.episodeId = episodeId;
            return this;
        }

        public GetReviewsRequest build() {
            return new GetReviewsRequest(this);
        }
    }
    // *** Getters and Setters

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }


    // *** Utility


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetReviewsRequest)) return false;
        GetReviewsRequest that = (GetReviewsRequest) o;
        return getEpisodeId().equals(that.getEpisodeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEpisodeId());
    }

    @Override
    public String toString() {
        return "GetReviewRequest{" +
                "episodeId='" + episodeId + '\'' +
                '}';
    }
}
