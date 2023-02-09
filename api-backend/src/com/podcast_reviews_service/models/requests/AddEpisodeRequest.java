package com.podcast_reviews_service.models.requests;

import java.util.Objects;

public class AddEpisodeRequest {
    private String podcast;
    private String name;
    private int episodeNr;

    // *** Constructors ***
    public AddEpisodeRequest() {
    }

    public AddEpisodeRequest(String podcast, String name, int episodeNr) {
        this.podcast = podcast;
        this.name = name;
        this.episodeNr = episodeNr;
    }

    // *** Builder Pattern ***
    public AddEpisodeRequest(Builder builder) {
        this. podcast = builder.podcast;
        this.name = builder.name;
        this.episodeNr = builder.episodeNr;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String podcast;
        private String name;
        private int episodeNr;

        private Builder() {
        }

        public Builder withPodcast(String podcast) {
            this.podcast = podcast;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEpisodeNr(int episodeNr) {
            this.episodeNr = episodeNr;
            return this;
        }

        public AddEpisodeRequest build() {
            return new AddEpisodeRequest(this);
        }
    }

    // *** Getters and Setters ***
    public String getPodcast() {
        return podcast;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof AddEpisodeRequest)) return false;
        AddEpisodeRequest that = (AddEpisodeRequest) o;
        return getEpisodeNr() == that.getEpisodeNr() && getPodcast().equals(that.getPodcast()) && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPodcast(), getName(), getEpisodeNr());
    }

    @Override
    public String toString() {
        return "AddEpisodeRequest{" +
                "podcast='" + podcast + '\'' +
                ", name='" + name + '\'' +
                ", episodeNr=" + episodeNr +
                '}';
    }
}
