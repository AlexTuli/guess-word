package com.epam.alex.io;

import com.epam.alex.exceptions.ReaderException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
@Component
public class SimpleReader implements Reader {

    private static final Logger log = Logger.getLogger(SimpleReader.class);
    public static final String URL_IS_EMPTY = "URL is empty.";

    @Override
    public InputStream readFile(String url) {
        if (url == null || url.isEmpty()){
            log.error(URL_IS_EMPTY);
            throw new ReaderException(URL_IS_EMPTY);
        }
        try {
            return  new FileInputStream(new File(url));
        } catch (FileNotFoundException e) {
            log.error("File not found.");
            throw new ReaderException(e);
        }
    }

}
