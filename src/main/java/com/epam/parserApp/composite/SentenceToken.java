package com.epam.parserApp.composite;

/**
 * Class extends Component class
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 *
 */
public interface SentenceToken<E extends Component> extends Component {

    boolean isWord();
    boolean isSymbol();
    boolean isPunctuation();
    boolean isWhitespace();

}
