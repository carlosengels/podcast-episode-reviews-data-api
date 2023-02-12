package com.podcast_reviews_service.exceptions;

public class DuplicateEpisodeException extends RuntimeException {
    private static final long serialVersionUID = 3858566126449435384L;

    public DuplicateEpisodeException() {
        super();
    }

    public DuplicateEpisodeException(String message) {
        super(message);
    }

    public DuplicateEpisodeException(Throwable cause) {
        super(cause);
    }

    public DuplicateEpisodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
