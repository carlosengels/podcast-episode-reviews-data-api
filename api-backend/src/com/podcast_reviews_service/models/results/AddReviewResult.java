package com.podcast_reviews_service.models.results;

import com.podcast_reviews_service.models.ReviewModel;

public class AddReviewResult {

    private ReviewModel reviewModel;

    public ReviewModel getReviewModel() {
        return reviewModel;
    }

    public void setReviewModel(ReviewModel reviewModel) {
        this.reviewModel = reviewModel;
    }

    // *** Builder Pattern ***
    public AddReviewResult(Builder builder) {
        this.reviewModel = builder.reviewModel;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private ReviewModel reviewModel;

        public Builder withReviewModel(ReviewModel reviewModel) {
            this.reviewModel = reviewModel;
            return this;
        }

        public AddReviewResult build() {
            return new AddReviewResult(this);
        }
    }
}
