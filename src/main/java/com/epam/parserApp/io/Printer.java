package com.epam.parserApp.io;


/**
 * Class contains method which displays on the
 * console program messages
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 */
public class Printer {

    /**
     * Displays messages
     * @param message
     */
    public static void print(String message) {
    if (message.isEmpty()) {
        message = "";
    }else if (message.equals("-")) {
         message = "-----------------------------------";
    }
        System.out.println(message);
    }
}
