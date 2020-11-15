package se.lexicon.alnajjar.booklender.exception;

import java.time.LocalDateTime;

public class APIError {
    private final LocalDateTime timestamp;
    private final Integer status;
    private final String error;
    private final String message;
    private String path;

    public APIError(LocalDateTime timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
