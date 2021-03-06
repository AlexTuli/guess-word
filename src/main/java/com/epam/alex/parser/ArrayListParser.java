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
    public static final char BREAK_LIKE_CHAR = '\n';
    public static final String UTF_8 = "UTF-8";
    public static final String ISO_8859_1 = "ISO-8859-1";

    @Override
    public Collection<String> parse(InputStream inputStream) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        try {
            int read;
            while ((read = inputStream.read()) != -1) {
                char charFromIS = (char) read;
                if (charFromIS == BREAK_LIKE_CHAR) {
                    byte bytes[] = builder.toString().trim().getBytes(ISO_8859_1);
                    result.add(new String(bytes, UTF_8).toLowerCase());
                    log.debug(builder);
                    builder = new StringBuilder();
                } else {
                    builder.append(charFromIS);
                }
            }
            log.debug(builder);
            byte bytes[] = builder.toString().trim().getBytes(ISO_8859_1);
            result.add(new String(bytes, UTF_8).toLowerCase());
        } catch (IOException e) {
            log.error("Can't parse file, IOException");
            throw new ParserException(e);
        }
        return result;
    }
}
