package com.epam.parserApp.composite;

import java.util.Iterator;
import java.util.List;

/**
 * Class extends AbstractComposite class and implements Iterable<>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Sentence extends AbstractComposite<SentenceToken> implements Iterable<SentenceToken>{

    @Override
    public void add(SentenceToken component) {
        super.add(component);
    }

    @Override
    public void remove(SentenceToken component) {
        super.remove(component);
    }

    @Override
    public List<SentenceToken> getComponents() {
        return super.getComponents();
    }

    @Override
    public void setComponents(List list) {
        super.setComponents(list);
    }

    @Override
    public Iterator<SentenceToken> iterator() {
        return getComponents().iterator();
    }





}
