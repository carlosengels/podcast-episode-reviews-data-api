package com.podcast_reviews_service.models.requests;

import java.util.Objects;

public class GetEpisodeRequest {
    private String podcast;
    private int episodeNr;

    // *** Constructors ***
    public GetEpisodeRequest() {
    }

    public GetEpisodeRequest(String podcast, int episodeNr) {
        this.podcast = podcast;
        this.episodeNr = episodeNr;
    }


    // *** Builder Pattern ***
    public GetEpisodeRequest(Builder builder) {
        this.podcast = builder.podcast;
        this.episodeNr = builder.episodeNr;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String podcast;
        private int episodeNr;

        private Builder() {
        }

        public Builder withPodcast(String podcast) {
            this.podcast = podcast;
            return this;
        }

        public Builder withEpisodeNr(int episodeNr) {
            this.episodeNr = episodeNr;
            return this;
        }

        public GetEpisodeRequest build() {
            return new GetEpisodeRequest(this);
        }
    }

    // *** Getters and Setters ***
    public String getPodcast() {
        return podcast;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    // *** Utility ***
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetEpisodeRequest)) return false;
        GetEpisodeRequest that = (GetEpisodeRequest) o;
        return getEpisodeNr() == that.getEpisodeNr() && getPodcast().equals(that.getPodcast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPodcast(), getEpisodeNr());
    }

    @Override
    public String toString() {
        return "GetEpisodeRequest{" +
                "podcast='" + podcast + '\'' +
                ", episodeNr=" + episodeNr +
                '}';
    }
}
