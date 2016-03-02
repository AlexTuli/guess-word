package com.epam.alex.dao;

import com.epam.alex.model.Word;

import java.util.List;

/**
 * Created on 3/1/2016.
 *
 * @author Alexander Bocharnikov
 */
public interface Dao {
    List<Word> readAll();
}