package com.podcast_reviews_service.exceptions;

public class EpisodeNotFoundException extends  RuntimeException{
    private static final long serialVersionUID = -7131178834616726836L;

    public EpisodeNotFoundException() {
        super();
    }

    public EpisodeNotFoundException(String message) {
        super(message);
    }

    public EpisodeNotFoundException(Throwable cause) {
        super(cause);
    }

    public EpisodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
