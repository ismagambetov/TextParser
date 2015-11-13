package com.epam.parserApp.composite;

/**
 * The hierarchy of classes are built by Composite Design Pattern
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public interface Composite<E extends Component> extends Component {

    void add(E component);
    void remove(E component);

}
