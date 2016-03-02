package com.epam.alex.parser;

import java.io.InputStream;
import java.util.Collection;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
public interface Parser {

    /**
     * Parse <code>InputStream</code> into Collection of Strings
     * @param inputStream InputStream of text file
     * @return Collection of Strings
     */
    Collection<String> parse(InputStream inputStream);

}
