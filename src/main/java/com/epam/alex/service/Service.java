package com.epam.alex.service;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
public interface Service<T> {

    T execute(Object...args);
}
