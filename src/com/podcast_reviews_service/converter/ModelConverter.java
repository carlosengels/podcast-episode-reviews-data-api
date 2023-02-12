package com.podcast_reviews_service.converter;

import com.podcast_reviews_service.dynamodb.models.Episode;
import com.podcast_reviews_service.dynamodb.models.Review;
import com.podcast_reviews_service.models.EpisodeModel;
import com.podcast_reviews_service.models.ReviewModel;
import com.podcast_reviews_service.models.ReviewsModel;
import com.podcast_reviews_service.models.TopRatedEpisodesModel;

import java.util.List;

public class ModelConverter {

    public EpisodeModel toEpisodeModel(Episode episode) {

        return EpisodeModel.builder()
                .withEpisodeId(episode.getEpisodeId())
                .withPodcast(episode.getPodcast())
                .withEpisodeNr(episode.getEpisodeNr())
                .withName(episode.getName())
                .withAvgRating(episode.getAvgRating())
                .build();
    }

    public ReviewModel toReviewModel(Review review) {
        return ReviewModel.builder()
                .withReviewId(review.getReviewId())
                .withReviewTitle(review.getReviewTitle())
                .withRating(review.getRating())
                .withPostedBy(review.getPostedBy())
                .withComment(review.getComment())
                .withEpisodeId(review.getEpisodeId())
                .build();
    }

    public ReviewsModel toReviewsModel(List<Review> reviews) {
        return ReviewsModel.builder().withReviews(reviews).build();
    }

    public TopRatedEpisodesModel toTopRatedEpisodesModel(List<Episode> episodes) {
        return TopRatedEpisodesModel.builder().withTopRatedEpisodes(episodes).build();
    }
}
