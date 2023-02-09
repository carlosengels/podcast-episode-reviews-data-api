package com.podcast_reviews_service.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.podcast_reviews_service.converter.ModelConverter;
import com.podcast_reviews_service.dynamodb.ReviewDao;
import com.podcast_reviews_service.dynamodb.models.Review;
import com.podcast_reviews_service.models.ReviewsModel;
import com.podcast_reviews_service.models.requests.GetReviewsRequest;
import com.podcast_reviews_service.models.results.GetReviewsResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GetReviewsActivity implements RequestHandler<GetReviewsRequest, GetReviewsResult> {

    private final Logger logger = LogManager.getLogger();
    private final ReviewDao reviewDao;

    public GetReviewsActivity() {
        this.reviewDao = new ReviewDao();
    }

    public GetReviewsActivity(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public GetReviewsResult handleRequest(GetReviewsRequest getReviewsRequest, Context context) {
        logger.info("Received GetReviewRequest " + getReviewsRequest);
        List<Review> reviews = reviewDao.getReviews(getReviewsRequest.getEpisodeId());

        ReviewsModel reviewsModel = new ModelConverter().toReviewsModel(reviews);

        return GetReviewsResult.builder().withReviewModel(reviewsModel).build();
    }
}
