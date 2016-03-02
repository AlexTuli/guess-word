package com.epam.alex.bo;

import com.epam.alex.dao.Dao;
import com.epam.alex.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 3/1/2016.
 *
 * @author Alexander Bocharnikov
 */
@Component(value = "businessObject")
public class MyBO implements BO{

    @Autowired
    private Dao dao;

    private static List<Word> words;

    public List<Word> getWords() {
        if (words == null) {
            words = dao.readAll();
        }
        return words;
    }
}
