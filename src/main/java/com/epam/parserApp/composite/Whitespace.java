package com.epam.parserApp.composite;

/**
 * Class implements Leaf and SentenceToken classes
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Whitespace implements Leaf, SentenceToken {

    private String whitespace;

    public Whitespace(String whitespace) {
        this.whitespace = whitespace;
    }

    public String getWhitespace() {
        return whitespace;
    }

    public void setWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }

    @Override
    public boolean isSymbol() {
        return false;
    }

    @Override
    public boolean isPunctuation() {
        return false;
    }

    @Override
    public boolean isWhitespace() {
        return true;
    }

    @Override
    public boolean isWord() {
        return false;
    }


    @Override
    public String toString() {
        return whitespace;
    }

}
