package com.podcast_reviews_service.models;

import com.podcast_reviews_service.dynamodb.models.Review;

import java.util.List;
import java.util.Objects;

public class ReviewsModel {

    private List<Review> reviews;

    public ReviewsModel() {
    }

    // *** Builder Pattern
    public ReviewsModel(Builder builder) {
        this.reviews = builder.reviews;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<Review> reviews;

        public Builder withReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public ReviewsModel build() {
            return new ReviewsModel(this);
        }
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewsModel)) return false;
        ReviewsModel that = (ReviewsModel) o;
        return getReviews().equals(that.getReviews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReviews());
    }

    @Override
    public String toString() {
        return "ReviewsModel{" +
                "reviews=" + reviews +
                '}';
    }
}
