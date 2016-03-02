package com.epam.alex.io;

import java.io.InputStream;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
public interface Reader {

    /**
     * Read the file from <code>URL</code>
     * @param url - url of the file
     * @return InputStream
     */
    InputStream readFile(String url);

}
