package com.epam.parserApp.main.exception;

/**
 *
 * Signals that an error of loading *.txt file  has occurred. This
 * class extends Exception class.
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.main
 */
public class ResourceGettingException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param   message
     *
     */
    public ResourceGettingException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and throwable cause
     *
     * @param   message
     * @param   cause
     *
     */
    public ResourceGettingException(String message, Throwable cause) {
        super(message, cause);
    }
}
