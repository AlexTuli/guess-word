package com.epam.alex.service;

import com.epam.alex.io.Reader;
import com.epam.alex.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Collection;

/**
 * Check first Argument
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
@Service
public class CheckWordService implements com.epam.alex.service.Service {

    public static final String PATH = "file-with-words.txt";
    @Autowired
    private Parser parser;
    @Autowired
    private Reader reader;


    @Override
    public Boolean execute(Object... args) {
        InputStream inputStream = reader.readFile(PATH);
        Collection<String> strings = parser.parse(inputStream);
        Boolean result = false;
        if (args.length > 0) {
            String str = (String) args[0];
            result = strings.contains(str);
        }
        return result;
    }
}
