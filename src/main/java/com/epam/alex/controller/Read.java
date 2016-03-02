package com.epam.alex.controller;

import com.epam.alex.dao.Dao;
import com.epam.alex.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 3/2/2016.
 *
 * @author Alexander Bocharnikov
 */
@RestController
public class Read {

    @Autowired
    private Dao dao;

    @RequestMapping("/readAll")
    public @ResponseBody List<Word> readAll(){
        return dao.readAll();
    }
}
