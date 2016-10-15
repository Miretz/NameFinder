package com.miretz.nlp.namefinder.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * Created by Miroslav on 15.10.2016.
 */
@ApiModel(value="Replacement", description="Replacement request and response object")
public class Replacement {

    private String replacement;
    private String inputSentence;
    private String outputSentence;

    public Replacement(){
        //JSON PURPOSE
    }

    public Replacement(String replacement, String inputSentence, String outputSentence) {
        this.replacement = replacement;
        this.inputSentence = inputSentence;
        this.outputSentence = outputSentence;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getInputSentence() {
        return inputSentence;
    }

    public void setInputSentence(String inputSentence) {
        this.inputSentence = inputSentence;
    }

    public String getOutputSentence() {
        return outputSentence;
    }

    public void setOutputSentence(String outputSentence) {
        this.outputSentence = outputSentence;
    }
}
