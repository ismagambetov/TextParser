package com.epam.parserApp.task;

import com.epam.parserApp.composite.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for get all words from Text type object
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.parserApp.composite
 */
public class WordCollector {

    private Text text;

    /**
     * Constructor which initializes parameter text
     * @param text
     */
    public WordCollector(Text text) {
        this.text = text;
    }

    /**
     * Fills <code>List<Word> list</code> with words
     * @return    list
     */
    public List<Word> getWords() {
        List<Word> list = new ArrayList<>();
        for (Paragraph paragraph: text) {
            for (Sentence sentence: paragraph) {
                for (SentenceToken sentenceToken: sentence) {
                    if (sentenceToken.isWord()) {
                        list.add((Word) sentenceToken);
                    }
                }
            }
        }
        return list;
    }

}
