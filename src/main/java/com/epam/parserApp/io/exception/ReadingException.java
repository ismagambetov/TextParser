package com.epam.parserApp.io.exception;

/**
 *
 * Signals that an I/O exception of reading InputStream has occurred. This
 * class extends Exception class.
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.io
 */
public class ReadingException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param   message
     *
     */
    public ReadingException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and throwable cause
     *
     * @param   message
     * @param   cause
     *
     */
    public ReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
