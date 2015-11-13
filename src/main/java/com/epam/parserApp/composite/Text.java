package com.epam.parserApp.composite;

import com.epam.parserApp.task.WordCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class extends AbstractComposite<> class and implements Iterable<>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public class Text extends AbstractComposite<Paragraph> implements Iterable<Paragraph>{

    @Override
    public void add(Paragraph component) {
        super.add(component);
    }

    @Override
    public void remove(Paragraph component) {
        super.remove(component);
    }


    @Override
    public List<Paragraph> getComponents() {
        return super.getComponents();
    }

    @Override
    public void setComponents(List list) {
        super.setComponents(list);
    }

    public Iterator wordIterator() {
        WordCollector wordInformator = new WordCollector(this);
        List<Word> list = new  ArrayList<>();
        list.addAll(wordInformator.getWords());
        return new WordIterator(list);
    }


    private class WordIterator implements Iterator<Word> {
        private List<Word> list;

        public WordIterator(List<Word> list ) {
            this.list = list;
        }

        int cursor;
        int lastElem = -1;

        @Override
        public boolean hasNext() {
            return cursor != list.size();
        }

        @Override
        public Word next() {
            int i = cursor;
            cursor = i + 1;
            return list.get(lastElem = i);
        }
    }

    @Override
    public Iterator<Paragraph> iterator() {
        return getComponents().iterator();
    }

}
