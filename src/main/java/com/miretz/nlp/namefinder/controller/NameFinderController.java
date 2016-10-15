package com.miretz.nlp.namefinder.controller;

import com.miretz.nlp.namefinder.service.NameFinder;
import com.miretz.nlp.namefinder.dto.Extraction;
import com.miretz.nlp.namefinder.service.NameFinderImpl;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miretz on 9.10.2016.
 */

@RestController
public class NameFinderController {

    @Autowired
    private NameFinder nameFinder;

    @RequestMapping(value = "/names", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "names", nickname = "names")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Extraction.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Extraction extractNames(@ApiParam(value = "Extraction request", required = true) @RequestBody Extraction extraction) {
        List<String> extractedNames = nameFinder.getNames(extraction.getSentence());
        extraction.setExtractedNames(extractedNames);
        return extraction;

    }
}
