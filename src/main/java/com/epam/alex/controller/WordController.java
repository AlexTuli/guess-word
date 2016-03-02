package com.epam.alex.controller;

import com.epam.alex.bo.BO;
import com.epam.alex.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 3/1/2016.
 *
 * @author Alexander Bocharnikov
 */
@RestController
public class WordController {

    @Autowired
    private BO bo;

    @RequestMapping("/check")
    public
    @ResponseBody
    Boolean check(@RequestParam(name = "word", defaultValue = "null") String word) {
        Word inputWord = new Word();
        inputWord.setWord(word);
        List<Word> words = bo.getWords();
        return words.contains(inputWord);
    }
}
