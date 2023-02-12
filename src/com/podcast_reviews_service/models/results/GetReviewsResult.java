package com.podcast_reviews_service.models.results;

import com.podcast_reviews_service.models.ReviewModel;
import com.podcast_reviews_service.models.ReviewsModel;

public class GetReviewsResult {
    private ReviewsModel reviewsModel;

    // *** Builder Pattern
    public GetReviewsResult(Builder builder) {
        this.reviewsModel = builder.reviewsModel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ReviewsModel reviewsModel;

        public Builder withReviewModel(ReviewsModel reviewsModel) {
            this.reviewsModel = reviewsModel;
            return this;
        }

        public GetReviewsResult build() {
            return new GetReviewsResult(this);
        }
    }

    public ReviewsModel getReviewModel() {
        return reviewsModel;
    }

    public void setReviewModel(ReviewsModel reviewsModel) {
        this.reviewsModel = reviewsModel;
    }
}
