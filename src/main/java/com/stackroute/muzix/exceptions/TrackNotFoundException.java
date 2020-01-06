package com.stackroute.muzix.exceptions;

public class TrackNotFoundException extends RuntimeException {
    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
