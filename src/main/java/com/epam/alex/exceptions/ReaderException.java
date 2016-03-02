package com.epam.alex.exceptions;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
public class ReaderException extends RuntimeException {

    public ReaderException() {
        super();
    }

    public ReaderException(String message) {
        super(message);
    }

    public ReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderException(Throwable cause) {
        super(cause);
    }
}
