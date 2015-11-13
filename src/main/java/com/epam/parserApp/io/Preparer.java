package com.epam.parserApp.io;

/**
 * Class removes BOM from String source
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 */
public class Preparer {

    private String stringSource;
    public static final String UTF8_BOM = "\uFEFF"; //UTF8_BOM constant symbols

    /**
     * Constructor initializes entering arguments
     * @param stringSource
     */
    public Preparer(String stringSource) {
        this.stringSource = stringSource;
    }

    /**
     * Calls removeBOM() method
     * @return string without BOM
     */
    public String prepare() {
        String removedBOMString = removeBOM(stringSource);
        return removedBOMString;
    }


    /**
     * Return method removes BOM from stringSource
     * @return string without BOM
     */
    private static String removeBOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

}
