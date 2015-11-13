package com.epam.parserApp.task;

import com.epam.parserApp.composite.Symbol;
import com.epam.parserApp.composite.Text;
import com.epam.parserApp.composite.Word;

import java.util.*;

/*
*
* №15. Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие)
* вхождения первой (последней) буквы этого слова.
*
* */

/**
 * Class for the solution of the task
 * which is described above
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.parserApp.composite
 * @see         com.epam.parserApp.parser
 */
public class TaskSolution {
    private Text text;
    private List<String> wordsList = new ArrayList<>();

    /**
     * Constructor which initializes parameter text
     * @param text
     */
    public TaskSolution(Text text) {
        this.text = text;
    }


    /**
     * The method executes task
     */
    public void execute() {
        //gets iterator() from text object
        Iterator<Word> it = text.wordIterator();
        while (it.hasNext()) {
            Word word =  it.next();
            String originalWord = word.toString(); //keep not changed word
            int wordSize = word.getWordSize();
            //passes words, which count of symbols less than 3
            if (wordSize > 3) {
                List<Symbol> list = word.getComponents();
                Symbol firstSymbol = list.get(0); //get first symbol of word
                Symbol lastSymbol  = list.get(wordSize-1); //get last symbol of word
                //cycle by word's part - without first and last symbols
                for(int i=1; i < list.size()-1; i++) {
                    Symbol symbol = list.get(i);
                    //if (true) symbol is removed from list
                    if (firstSymbol.equals(symbol) || lastSymbol.equals(symbol)) {
                        list.remove(i);
                    }
                }
                //adds to list two words for displaying it
                String changedWord = word.toString();
                if (!originalWord.equals(changedWord)) {
                    wordsList.add(originalWord.concat(" - ").concat(changedWord));
                }
            }

        }
    }


    /**
     * Returns filled <code>List<String> wordsList</code>
     * @return wordsList
     */
    public String getWordsList() {
            return wordsList.toString();
        }

}
