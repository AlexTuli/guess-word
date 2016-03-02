package com.epam.alex.controller;

import com.epam.alex.service.Service;
import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(WordController.class);
    private static final String SPACE_REGEX = "\\s+";
    private static final String SPACE_STRING = " ";
    @Autowired
    private Service<Boolean> checkWordService;

    @RequestMapping("/check")
    public
    @ResponseBody
    Boolean check(@RequestParam(name = "word", defaultValue = "") String word) {
        if (word.isEmpty()) {
            log.debug("The word is empty.");
            return false;
        }
        //Here we also remove extra white spaces for just one
        return checkWordService.execute(word.trim().replaceAll(SPACE_REGEX, SPACE_STRING));
    }
}
