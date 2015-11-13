package com.epam.parserApp.main;

import com.epam.parserApp.io.Preparer;
import com.epam.parserApp.io.Printer;
import com.epam.parserApp.main.exception.PropertyLoadException;
import com.epam.parserApp.main.exception.ResourceGettingException;
import com.epam.parserApp.parser.RegexParser;
import com.epam.parserApp.composite.*;
import com.epam.parserApp.io.Reader;
import com.epam.parserApp.io.exception.ReadingException;
import com.epam.parserApp.parser.exception.AccessToTheClassException;
import com.epam.parserApp.parser.exception.ObjectCreateException;
import com.epam.parserApp.task.TaskSolution;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.log4j.Logger;

/**
 * <p>Task 2: The Text Parser App</p>
 *
 * <p>It is <code>Main.class<code/> in which the following actions are carried out:
 * readings the text file from resources, preparation of the read file for parsing,
 * parsing of the text. This class throws different exceptions that are called
 * during code execution.</p>
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 * @see         com.epam.parserApp.io
 * @see         com.epam.parserApp.parser
 * @see         com.epam.parserApp.task
 */
public class Main {
    //Just for to test logger
    private static final Logger log = Logger.getLogger(Main.class);
     /**
     * @param args
     * @throws ReadingException
     * @throws ObjectCreateException
     * @throws AccessToTheClassException
     * @throws ResourceGettingException
     */
    public static void main( String[] args ) throws ReadingException, ObjectCreateException,
            ResourceGettingException, AccessToTheClassException, PropertyLoadException {

         //.*txt file is loaded into InputStream by methods getClassLoader(),getResourceAsStream()
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("text.txt");
        if (inputStream == null) {
            throw new ResourceGettingException("Error loading file from resource. " +
                    "\nPlease, check the path and filename are correct.");
        }

        Charset charset = Charset.forName("UTF-8");
        Printer.print("Start process...");
        //Just for to test logger
        log.info("Just for test logger");
        Printer.print("-");

        /* It is created instance of Reader class; The method readIntoString()
            returns String type value for other purposes */
        Printer.print("Reading text...");
        Reader reader         = new Reader(inputStream,charset);
        String stringSource   = reader.readIntoString();
        Printer.print("The text has been red!");
        Printer.print("-");


        /* It is created instance of Preparer class; The method prepare()
           returns String type value which was prepared for parsing */
        Printer.print("Preparing text...");
        Preparer preparer     = new Preparer(stringSource);
        String preparedString = preparer.prepare();
        Printer.print("The text has been prepared!");
        Printer.print("-");

        /* It is created new object that entered into "parser" variable.
           Then it gets <Text> type value by parse() method. */
        Printer.print("Parsing text...");
        RegexParser parser   = new RegexParser();
        Text text = parser.parse(preparedString, Text.class);
        Printer.print("The text has been parsed!");
        Printer.print("-");

        /* In this block it checks for equality to String object:
           parsedStringText and preparedString.*/
        Printer.print("Comparing parsed text with original...");
        String parsedStringText = text.toString();
        boolean isEquals = parsedStringText.equals(preparedString);

        String comparingResult;
        if (isEquals) {
            comparingResult = "Texts are equal!";
        }else comparingResult = "Texts aren't equal!";

        Printer.print("Comparing is finished. Result: " + comparingResult);
        Printer.print("-");


        //Task execution block
        Printer.print("The task's solution process...");
        TaskSolution task    = new TaskSolution(text);
        task.execute();
        Printer.print("The task is solved! The changed words are being under:");
        Printer.print("");
        Printer.print(task.getWordsList());
        Printer.print("-");
        Printer.print("The full text with changed words is being under:");
        Printer.print("");
        Printer.print(text.toString());
        Printer.print("-");
        Printer.print("End process!");




    }



}
