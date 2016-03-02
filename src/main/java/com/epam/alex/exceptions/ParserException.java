package com.epam.alex.exceptions;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
public class ParserException extends RuntimeException {
    public ParserException() {
        super();
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParserException(Throwable cause) {
        super(cause);
    }
}
