package com.epam.parserApp.parser;
import com.epam.parserApp.main.exception.PropertyLoadException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 *
 * Manages *.properties files.
 * Contains getProperties() method for getting loaded properties.
 *
 * @author      Damir Ismagambetov
 * @see         com.epam.parserApp.parser
 */
public class PropertyManager {

    /**
    *
    * Returns properties were loaded from resources
    * @return properties
    * @throws PropertyLoadException
    *
    */
    public Properties getProperties() throws PropertyLoadException {
        InputStream in = PropertyManager.class.getClassLoader().getResourceAsStream("regex.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new PropertyLoadException("Error loading properties", e);
        }
        return properties;

    }





}
