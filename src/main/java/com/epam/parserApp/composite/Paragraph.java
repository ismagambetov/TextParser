package com.epam.parserApp.composite;

import java.util.Iterator;
import java.util.List;

/**
 * Class extends AbstractComposite<> class and implements Iterable<>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Paragraph extends AbstractComposite<Sentence> implements Iterable<Sentence>{

    @Override
    public void add(Sentence component) {
        super.add(component);
    }

    @Override
    public void remove(Sentence component) {
        super.remove(component);
    }


    @Override
    public List<Sentence> getComponents() {
        return super.getComponents();
    }

    @Override
    public void setComponents(List list) {
        super.setComponents(list);
    }

    @Override
    public Iterator<Sentence> iterator() {
        return getComponents().iterator();
    }

}
