package com.epam.parserApp.composite;

import java.util.List;

/**
 * Class extends AbstractComposite<> and implements SentenceToken classes
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Word extends AbstractComposite<Symbol> implements SentenceToken{
    private int wordSize = 0;


    @Override
    public void add(Symbol component) {
        super.add(component);
        calculateSymbolCount();
    }

    @Override
    public void remove(Symbol component) {
        super.remove(component);
    }

    @Override
    public List<Symbol> getComponents() {
        return super.getComponents();
    }

    @Override
    public void setComponents(List<Symbol> components) {
        super.setComponents(components);
    }

    @Override
    public boolean isWord() {
        return true;
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
        return false;
    }

    public void calculateSymbolCount() {
        wordSize +=1;
    }

    public int getWordSize() {
        return wordSize;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
