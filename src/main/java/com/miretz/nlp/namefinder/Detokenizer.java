package com.miretz.nlp.namefinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Miretz on 6.10.2016.
 */
public class Detokenizer {

    public static String detokenize(final List<String> sourceTokens) {

        List<String> tokens = new ArrayList<>();
        tokens.addAll(sourceTokens);

        //Add an empty token at the beginning because loop checks as position-1 and "" is in noSpaceAfter
        tokens.add(0, "");

        List<String> noSpaceBefore = new LinkedList<String>(Arrays.asList(",", ".", ";", ":", ")", "}", "]"));
        List<String> noSpaceAfter = new LinkedList<String>(Arrays.asList("(", "[", "{", "\"", "", "'", "*"));

        StringBuilder sentence = new StringBuilder();

        for (int i = 1; i < tokens.size(); i++) {
            if (noSpaceBefore.contains(tokens.get(i)) || noSpaceAfter.contains(tokens.get(i - 1))) {
                sentence.append(tokens.get(i));
            } else {
                sentence.append(" " + tokens.get(i));
            }

            //matches starting and ending quotes, so there are no extra spaces
            if ("\"".equals(tokens.get(i - 1))) {
                if (noSpaceAfter.contains("\"")) {
                    noSpaceAfter.remove("\"");
                    noSpaceBefore.add("\"");
                } else {
                    noSpaceAfter.add("\"");
                    noSpaceBefore.remove("\"");
                }
            }
        }
        return sentence.toString();
    }
}
