package com.epam.alex.parser;

import com.epam.alex.exceptions.ParserException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Parse InputStream into <code>ArrayStream<String></code>
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
@Component
public class ArrayListParser implements Parser {

    private static final Logger log = Logger.getLogger(ArrayListParser.class);
    public static final char SPACE_CHAR = ' ';
    public static final char BREAK_LIKE_CHAR = '\n';

    @Override
    public Collection<String> parse(InputStream inputStream) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        try {
            int read;
            while ((read = inputStream.read()) != -1) {
                char charFromIS = (char) read;
                if (charFromIS == BREAK_LIKE_CHAR || charFromIS == SPACE_CHAR) {
                    result.add(builder.toString().trim());
                    log.debug(builder);
                    builder = new StringBuilder();
                } else {
                    builder.append(charFromIS);
                }
            }
            log.debug(builder);
            result.add(builder.toString());
        } catch (IOException e) {
            log.error("Can't parse file, IOException");
            throw new ParserException(e);
        }
        return result;
    }
}
