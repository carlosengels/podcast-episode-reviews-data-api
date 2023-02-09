package com.podcast_reviews_service.utils;

import org.apache.commons.lang3.RandomStringUtils;

public final class PodcastReviewsUtils {

    static final int RANDOM_ID_LENGTH = 8;


    public static String generateRandomID() {
        return RandomStringUtils.randomAlphanumeric(RANDOM_ID_LENGTH);
    }
}
