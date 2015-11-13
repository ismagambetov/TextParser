package com.epam.parserApp.parser;

import com.epam.parserApp.composite.*;
import com.epam.parserApp.main.exception.PropertyLoadException;
import com.epam.parserApp.parser.exception.AccessToTheClassException;
import com.epam.parserApp.parser.exception.ObjectCreateException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * The class is intended for performance of parsing of the text source
 * entering as parameter. The text divides into paragraphs, paragraphs on sentences,
 * sentences on its components: words, punctuations, symbols and whitespaces.
 * Elements of the text gathers in the Text object by using <code>Composite Design Pattern</code>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.parserApp.composite
 */
public class RegexParser {

    private Map<Class<? extends Component>, String> regexMap;
    private Map<Class<? extends Composite>, Class<? extends Component>> compositeMap;
    private Properties properties;

    /**
     * Constructor specifying propertyManager, regexMap, compositeMap to create,
     * and filling them by values.
     *
     * @throws   PropertyLoadException
     */
    public RegexParser() throws PropertyLoadException {
        PropertyManager propertyManager = new PropertyManager();
        properties = propertyManager.getProperties();

        regexMap = new HashMap<>();
        compositeMap = new HashMap<>();
        regexMap = getRegexMap();
        compositeMap = getCompositeMap();
    }

    /**
     * This method divide String text to the parts. It is used recursive method
     * for gathering into main object Text its element objects. Eventually, returns Text type object.
     * Eventually, returns Text object
     *
     * @param stringSource                 entering String type parameters for divide to elements(parsing)
     * @param compositeClass               entering Class type parameters for detecting what type of the
     *                                     next object to create.
     *
     * @return                             <code><T><code/> type object recursively.
     * @throws ObjectCreateException
     * @throws AccessToTheClassException
     */
    public <T extends Composite> T parse(String stringSource, Class<T> compositeClass) throws ObjectCreateException,
                                                                                                AccessToTheClassException {
        Matcher matchedStrings = null;
        int multiline = 0;
        // first initialization object
        T obj = null;
        try {
            //create object
            obj = compositeClass.newInstance();
        } catch (InstantiationException e) {
            throw new ObjectCreateException("The specified class object: "+ compositeClass +"" +
                    " cannot be instantiated.", e);
        } catch (IllegalAccessException e) {
            throw new AccessToTheClassException("The currently executing method does not have access " +
                    "to the definition of the specified class, field, method or constructor.", e);
        }
        //detecting what new object we need to create
        Class nextClass = compositeMap.get(compositeClass);

        //from regexMap is defined regular expression
        String regex = regexMap.get(compositeClass);

        //MULTILINE method is used for only Text type object
        if (obj instanceof Text) {multiline = Pattern.MULTILINE;}
        matchedStrings = Pattern.compile(regex,multiline).matcher(stringSource);
        while(matchedStrings.find()) {
            String matchedString = matchedStrings.group(); //catch matched string

            //this block of code for creating sentences' tokens
            if (nextClass == SentenceToken.class) {
                String regexWord       = regexMap.get(Word.class);
                String regexPunct      = regexMap.get(Punctuation.class);
                if (matchedString.matches(regexWord)) {
                    Word word = new Word();
                    char[] symbolsMassive = matchedString.toCharArray();
                    for(char symbol: symbolsMassive) {
                        Character c = Character.valueOf(symbol); // get symbol from character cache
                        Symbol ss = new Symbol(c);
                        word.add(ss);
                    }
                    obj.add(word);
                }else if (matchedString.matches(regexPunct)) {
                    Punctuation punct = new Punctuation(matchedString);
                    obj.add(punct);
                }else {
                    Whitespace whitespace = new Whitespace(matchedString);
                    obj.add(whitespace);
                }
            }
            /*
            * created object invokes its own add() method which adds received object recursively.
            * recursive method is used if nextClass doesn't SentenceToken.class
            */
            if (nextClass != SentenceToken.class) {
                Component component = parse(matchedString, nextClass);
                obj.add(component);
            }
            // returns object if it is last entry
            if (matchedStrings.regionEnd() == matchedStrings.end()) {
                return obj;
            }
        }
        //returns main object Text
        return obj;
    }

    /**
     * <code>Map<K,V>regexMap</code> is filled with regex according to type<code>Class<code/> classes
     * @return  filled regexMap
     */
    public Map<Class<? extends Component>, String> getRegexMap() {

            regexMap.put(Text.class,        properties.getProperty("REGEX_FOR_PARAGRAPH"));
            regexMap.put(Paragraph.class,   properties.getProperty("REGEX_FOR_SENTENCE"));
            regexMap.put(Sentence.class,    properties.getProperty("REGEX_FOR_TOKEN"));
            regexMap.put(Word.class,        properties.getProperty("REGEX_FOR_WORD"));
            regexMap.put(Punctuation.class, properties.getProperty("REGEX_FOR_PUNCTUATION"));

            return regexMap;

        }

        /**
         * <code>Map<K,V>compositeMap</code> is filled type <code>Class<code/> classes
         * By <code>compositeMap</code> it is easy to define which next class must be created.
         *
         * @return  filled compositeMap
         */
        public Map<Class<? extends Composite>, Class<? extends Component>> getCompositeMap() {

            compositeMap.put(Text.class,      Paragraph.class);
            compositeMap.put(Paragraph.class, Sentence.class);
            compositeMap.put(Sentence.class,  SentenceToken.class);

            return compositeMap;

        }





}
