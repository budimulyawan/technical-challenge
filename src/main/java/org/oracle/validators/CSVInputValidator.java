package org.oracle.validators;

import org.oracle.helpers.Constant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVInputValidator implements InputValidator {

    @Override
    public InputValidationResult validate(String line) {
        if (line == null) return new InputValidationResult(false, "Argument line must not be null");
        if (line.trim().isEmpty()) return new InputValidationResult(false, "Input line must not be blank");

        Pattern pattern = Pattern.compile(Constant.INPUT_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        boolean matchFound = matcher.find();
        if(matchFound) {
            return new InputValidationResult(true, null);
        } else {
            return new InputValidationResult(false, String.format("Unable to validate line: %s", line));
        }

    }
}
