package com.podcast_reviews_service.models;


import java.util.Objects;

public class EpisodeModel {

    private String episodeId;
    private String podcast;
    private String name;
    private int episodeNr;
    private int avgRating;

    public EpisodeModel() {
    }

    public EpisodeModel(Builder builder) {
        this.episodeId = builder.episodeId;
        this.podcast = builder.podcast;
        this.name = builder.name;
        this.episodeNr = builder.episodeNr;
        this.avgRating = builder.avgRating;

    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String episodeId;
        private String podcast;
        private String name;
        private int episodeNr;
        private int avgRating;

        public Builder withEpisodeId(String episodeId) {
            this.episodeId = episodeId;
            return this;
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

        public Builder withAvgRating(int avgRating) {
            this.avgRating = avgRating;
            return this;
        }
        public EpisodeModel build() {
            return new EpisodeModel(this);
        }
    }

    //***Getters and Setters***
    public String getEpisodeId() {
        return episodeId;
    }
    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }
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
    public double getAvgRating() {
        return avgRating;
    }
    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EpisodeModel)) return false;
        EpisodeModel that = (EpisodeModel) o;
        return getEpisodeNr() == that.getEpisodeNr() && Double.compare(that.getAvgRating(), getAvgRating()) == 0 && getEpisodeId().equals(that.getEpisodeId()) && getPodcast().equals(that.getPodcast()) && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEpisodeId(), getPodcast(), getName(), getEpisodeNr(), getAvgRating());
    }

    @Override
    public String toString() {
        return "EpisodeModel{" +
                "episodeId='" + episodeId + '\'' +
                ", podcast='" + podcast + '\'' +
                ", name='" + name + '\'' +
                ", epsiodeNr=" + episodeNr +
                ", avgRating=" + avgRating +
                '}';
    }
}
