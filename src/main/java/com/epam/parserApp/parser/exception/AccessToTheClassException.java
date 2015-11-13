package com.epam.parserApp.parser.exception;


/**
 *
 * Thrown from an IllegalAccess Exception. It has occurred when an application
 * tries to reflectively create an instance
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.main
 */
public class AccessToTheClassException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param   message
     *
     */
    public AccessToTheClassException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and throwable cause
     *
     * @param   message
     * @param   cause
     *
     */
    public AccessToTheClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
