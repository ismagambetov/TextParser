package com.epam.parserApp.composite;

import java.util.*;

/**
 * Class implements Composite class. There are methods for List<E> type
 * componentList, and  toString() for transform Text to String type object
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.parserApp.composite
 */
public abstract class AbstractComposite<E extends Component> implements Composite<E> {

    private List<E> componentList = new ArrayList<>();
    private int sortOrder = 0;

    @Override
    public void add(E component) {

        componentList.add(component);
    }

    @Override
    public void remove(E component) {
        componentList.remove(component);
    }

    public List<E> getComponents() {
        return componentList;
    }

    public void setComponents(List<E> components) {

        this.componentList = components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractComposite<?> that = (AbstractComposite<?>) o;

        if (sortOrder != that.sortOrder) return false;
        return !(componentList != null ? !componentList.equals(that.componentList) : that.componentList != null);

    }

    @Override
    public int hashCode() {
        int result = componentList != null ? componentList.hashCode() : 0;
        result = 31 * result + sortOrder;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(E component:componentList) {
            sb.append(component.toString());
            if (component instanceof Paragraph) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
