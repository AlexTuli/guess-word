package com.epam.alex.controller;

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

    @RequestMapping("/check")
    public
    @ResponseBody
    Boolean check(@RequestParam(name = "word", defaultValue = "null") String word) {
        return false;
    }
}
