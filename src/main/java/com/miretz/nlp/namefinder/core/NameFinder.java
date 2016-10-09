package com.miretz.nlp.namefinder.core;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Miretz on 6.10.2016.
 */
public class NameFinder {

    private TokenNameFinderModel model;
    private NameFinderME finder;
    private Tokenizer tokenizer;

    public NameFinder() throws IOException {

        // Load the model file downloaded from OpenNLP
        // http://opennlp.sourceforge.net/models-1.5/en-ner-person.bin
        model = new TokenNameFinderModel(new File("input/en-ner-person.bin"));

        // Create a NameFinder using the model
        finder = new NameFinderME(model);

        tokenizer = SimpleTokenizer.INSTANCE;
    }

    public List<String> getNames(final String sentence) {

        // Split the sentence into tokens
        String[] tokens = tokenizer.tokenize(sentence);

        // Find the names in the tokens and return Span objects
        Span[] nameSpans = finder.find(tokens);

        return Arrays.asList(Span.spansToStrings(nameSpans, tokens));
    }

    public String replaceNamesWith(final String sentence, final String placeholder) {

        // Split the sentence into tokens
        String[] tokens = tokenizer.tokenize(sentence);

        // Find the names in the tokens and return Span objects
        Span[] nameSpans = finder.find(tokens);

        for (Span span : nameSpans) {
            tokens[span.getStart()] = placeholder;
            for (int i = span.getStart() + 1; i < span.getEnd(); i++) {
                tokens[i] = "";
            }
        }

        return Detokenizer.detokenize(Arrays.asList(tokens));

    }

}
