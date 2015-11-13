package com.epam.parserApp.parser.exception;

/**
 *
 * Thrown from an Instantiation Exception. It has occurred when an application
 * tries to create an instance of a class using
 * the {@code newInstance} method in class
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.parser
 */
public class ObjectCreateException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param   message
     *
     */
    public ObjectCreateException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and throwable cause
     *
     * @param   message
     * @param   cause
     *
     */
    public ObjectCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
