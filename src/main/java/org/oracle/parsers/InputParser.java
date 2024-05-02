package org.oracle.parsers;

import org.oracle.data.CustomerProjectData;

import java.util.List;

public interface InputParser {
    InputParsingResult parse(String[] input);
}
