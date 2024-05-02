package org.oracle.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCVTInputValidator {
    @Test
    void testValidateNullInput() {
        InputValidator validator = new CSVInputValidator();
        InputValidationResult result = validator.validate(null);
        assertFalse(result.getValid());
        assertNotNull(result.getErrorMessage());
    }

    @Test
    void testValidateBlankInput() {
        InputValidator validator = new CSVInputValidator();
        InputValidationResult result = validator.validate("   ");
        assertFalse(result.getValid());
        assertNotNull(result.getErrorMessage());
    }

    @Test
    void testValidateInvalidInput() {
        InputValidator validator = new CSVInputValidator();
        InputValidationResult result = validator.validate("Budi Mulyawan");
        assertFalse(result.getValid());
        assertNotNull(result.getErrorMessage());
    }

    @Test
    void testValidateValidInput() {
        InputValidator validator = new CSVInputValidator();
        InputValidationResult result = validator.validate("3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s");
        assertTrue(result.getValid());
        assertNull(result.getErrorMessage());
    }
}
