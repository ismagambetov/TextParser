package com.epam.parserApp.composite;

/**
 * Class implements Leaf and SentenceToken classes
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Punctuation implements Leaf, SentenceToken {

    private String punctuation;

    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }


    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String whiteSpace) {
        this.punctuation = whiteSpace;
    }

    @Override
    public boolean isSymbol() {
        return false;
    }

    @Override
    public boolean isWord() {
        return false;
    }

    @Override
    public boolean isPunctuation() {
        return true;
    }

    @Override
    public boolean isWhitespace() {
        return false;
    }


    @Override
    public String toString() {
        return punctuation;
    }
}
