package com.podcast_reviews_service.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.podcast_reviews_service.dynamodb.models.Review;

import java.util.ArrayList;
import java.util.List;

@DynamoDBTable(tableName = "PodcastReviewService-Episodes")
public class Episode {
    private String podcast;
    private int episodeNr;
    private String name;
    private int avgRating;
    private String episodeId;
    private List<Review> reviews;

    public Episode() {
    }
    @DynamoDBHashKey (attributeName = "podcast")
    public String getPodcast() {
        return podcast;
    }

    @DynamoDBRangeKey(attributeName = "episodeNr")
    public int getEpisodeNr() {
        return episodeNr;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }
    @DynamoDBIndexHashKey(attributeName = "avgRating", globalSecondaryIndexName = "TopRatedEpisodesIndex")
    public int getAvgRating() {
        return avgRating;
    }

    @DynamoDBIndexRangeKey(attributeName = "episodeId", globalSecondaryIndexName = "TopRatedEpisodesIndex")
    public String getEpisodeId() {
        return episodeId;
    }

    @DynamoDBAttribute(attributeName = "reviews")
    public List<Review> getReviews() {
        return reviews;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setPodcast(String podcast) {
        this.podcast = podcast;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }
}
