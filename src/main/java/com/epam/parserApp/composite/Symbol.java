package com.epam.parserApp.composite;

/**
 * Class implements Leaf and SentenceToken classes
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Symbol implements Leaf, SentenceToken {

    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isLowerCase(Character symbol) {
        return symbol.isLowerCase(symbol);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isDigit(Character symbol) {
        return symbol.isDigit(symbol);
    }

    @Override
    public boolean isSymbol() {
        return true;
    }

    @Override
    public boolean isWord() {
        return false;
    }

    @Override
    public boolean isPunctuation() {
        return false;
    }

    @Override
    public boolean isWhitespace() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol == symbol1.symbol;

    }

    @Override
    public int hashCode() {
        return (int) symbol;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}
