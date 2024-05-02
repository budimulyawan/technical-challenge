package org.oracle.parsers;

import org.junit.jupiter.api.Test;
import org.oracle.validators.CSVInputValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.oracle.helpers.HelperUtil.readLines;

public class TestCSVInputParser {
    @Test
    void testParseNullInput() {
        CSVInputValidator validator = new CSVInputValidator();
        InputParser csvParser = new CSVInputParser(validator);
        InputParsingResult result = csvParser.parse(null);

        assertEquals(0, result.getTotalErrorParsed());
        assertEquals(0, result.getTotalParsedInput());
        assertEquals(0, result.getTotalSuccessfullyParsed());
    }

    @Test
    void testParseWithValidInput() throws IOException {
        String[] input = readLines(getClass().getClassLoader().getResource("test.txt").getFile());
        CSVInputValidator validator = new CSVInputValidator();
        InputParser csvParser = new CSVInputParser(validator);
        InputParsingResult result = csvParser.parse(input);

        assertEquals(0, result.getTotalErrorParsed());
        assertEquals(5, result.getTotalParsedInput());
        assertEquals(5, result.getTotalSuccessfullyParsed());
    }
}
