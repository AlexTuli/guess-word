package com.epam.alex.service;

import com.epam.alex.io.Reader;
import com.epam.alex.parser.Parser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource(value = {"classpath:application.properties"})
public class CheckWordService implements com.epam.alex.service.Service {

    private static final Logger log = Logger.getLogger(CheckWordService.class);
    public static final String FILE_URL = "file.url";
    @Autowired
    private Parser parser;
    @Autowired
    private Reader reader;
    @Autowired
    private Environment environment;



    @Override
    public Boolean execute(Object... args) {
        InputStream inputStream = reader.readFile(environment.getRequiredProperty(FILE_URL));
        Collection<String> strings = parser.parse(inputStream);
        Boolean result = false;
        if (args.length > 0) {
            String str = (String) args[0];
            log.debug("Word is " + str);
            result = strings.contains(str.toLowerCase());
        }
        return result;
    }
}
