package com.epam.parserApp.io;

import com.epam.parserApp.io.exception.ReadingException;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Class reads *.txt file
 *
 * @author      Damir Ismagambetov
 * @version     1.0
 */
public class Reader {

    private InputStream is;
    private Charset charset;

    /**
     * Constructor initializes entering arguments
     *
     * @param           is - InputStream type parameter
     * @param           charset - Charset type parameter
     */
    public Reader(InputStream is, Charset charset) {
        this.is = is;
        this.charset = charset;
    }

    /**
     * Return method reads InputStream source.
     *
     * @return     the read text
     * @throws     ReadingException
     */
    public String readIntoString() throws ReadingException {
        //creating instance of StringBuilder class
        StringBuilder sb = new StringBuilder();

        try {
            //creating instance of BufferedReader class, and InputStreamReader
            BufferedReader br    = new BufferedReader(new InputStreamReader(is, charset));

            String line;
            //reads each line
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException e) { // exception if something goes wrong
            throw new ReadingException("Error reading from file.", e);
        }
        return sb.toString();
    }



}
