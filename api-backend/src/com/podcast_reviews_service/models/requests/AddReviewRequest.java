package com.podcast_reviews_service.models.requests;

import java.util.Objects;

public class AddReviewRequest {

    private String reviewTitle;
    private int rating;
    private String postedBy;
    private String comment;
    private String episodeId;

    public AddReviewRequest() {
    }

    public AddReviewRequest(String reviewTitle, int rating, String postedBy, String comment, String episodeId) {
        this.reviewTitle = reviewTitle;
        this.rating = rating;
        this.postedBy = postedBy;
        this.comment = comment;
        this.episodeId = episodeId;
    }

    // *** Builder Pattern ***
    public AddReviewRequest(Builder builder) {
        this.reviewTitle = builder.reviewTitle;
        this.rating = builder.rating;
        this.postedBy = builder.postedBy;
        this.comment = builder.comment;
        this.episodeId = builder.episodeId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String reviewTitle;
        private int rating;
        private String postedBy;
        private String comment;
        private String episodeId;

        public Builder() {
        }

        public Builder withReviewTitle(String reviewTitle) {
            this.reviewTitle = reviewTitle;
            return this;
        }

        public Builder withRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder withPostedBy(String postedBy) {
            this.postedBy = postedBy;
            return this;
        }

        public Builder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder withEpisodeId(String episodeId) {
            this.episodeId = episodeId;
            return this;
        }

        public AddReviewRequest build() {
            return new AddReviewRequest(this);
        }

    }

    // *** Getters and Setters ***
    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    // *** Utility ***

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddReviewRequest)) return false;
        AddReviewRequest that = (AddReviewRequest) o;
        return getRating() == that.getRating() && getReviewTitle().equals(that.getReviewTitle()) && getPostedBy().equals(that.getPostedBy()) && getComment().equals(that.getComment()) && getEpisodeId().equals(that.getEpisodeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviewTitle(), getRating(), getPostedBy(), getComment(), getEpisodeId());
    }

    @Override
    public String toString() {
        return "AddReviewRequest{" +
                "reviewTitle='" + reviewTitle + '\'' +
                ", rating=" + rating +
                ", postedBy='" + postedBy + '\'' +
                ", comment='" + comment + '\'' +
                ", episodeId='" + episodeId + '\'' +
                '}';
    }
}
