package uk.sky.jkamp.SpringBoot.exceptions;

public class FlightServiceException extends RuntimeException {
    private static final Throwable cause = null;

    public FlightServiceException(String message) {
        super(message, cause);
    }

    public FlightServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FlightServiceException(Throwable cause) {
        super(cause);
    }

    public FlightServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FlightServiceException() {
    }
}