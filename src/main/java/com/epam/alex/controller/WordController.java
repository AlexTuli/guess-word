package com.epam.alex.controller;

import com.epam.alex.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 3/1/2016.
 *
 * @author Alexander Bocharnikov
 */
@RestController
public class WordController {

    @Autowired
    private Service<Boolean> checkWordService;

    @RequestMapping("/check")
    public
    @ResponseBody
    Boolean check(@RequestParam(name = "word", defaultValue = "") String word) {
        if (word.isEmpty()) {
            return false;
        }
        return checkWordService.execute(word.trim());
    }
}
