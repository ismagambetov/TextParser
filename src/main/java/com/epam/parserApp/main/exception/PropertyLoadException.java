package com.epam.parserApp.main.exception;

/**
 *
 * Signals that an I/O exception of loading properties has occurred. This
 * class extends Exception class.
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.main
 */
public class PropertyLoadException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param   message
     *
     */
    public PropertyLoadException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and throwable cause
     *
     * @param   message
     * @param   cause
     *
     */
    public PropertyLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
