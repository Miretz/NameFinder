package com.miretz.nlp.namefinder.controller;

import com.miretz.nlp.namefinder.core.NameFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miretz on 9.10.2016.
 */

@Controller
public class NameFinderController {

    public static final Logger log = LoggerFactory.getLogger(NameFinderController.class);

    @RequestMapping("/names")
    public String getNames(@RequestParam(value="sentence", required=true, defaultValue="") String sentence, Model model) {

        List<String> names = new ArrayList<>();

        try {
            NameFinder nameFinder = new NameFinder();
            names = nameFinder.getNames(sentence);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        model.addAttribute("namesList", names);
        return "names";

    }
}
