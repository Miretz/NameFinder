package com.miretz.nlp.namefinder.service;

import java.util.List;

/**
 * Created by Miroslav on 15.10.2016.
 */
public interface NameFinder {

    List<String> getNames(String sentence);

    String replaceNamesWith(String sentence, String placeholder);
}
