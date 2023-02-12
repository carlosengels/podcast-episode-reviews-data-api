package com.podcast_reviews_service.models.requests;

public class GetTopRatedEpisodesRequest {

    // *** Blank Builder ***
    public GetTopRatedEpisodesRequest(Builder builder) {
    }

    public static final class Builder {
        private Builder() {
        }

        public GetTopRatedEpisodesRequest builder() {
            return new GetTopRatedEpisodesRequest(this);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "GetTopRatedEpisodesRequest{}";
    }
}
