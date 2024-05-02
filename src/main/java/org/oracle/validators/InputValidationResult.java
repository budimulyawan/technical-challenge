package org.oracle.validators;

public class InputValidationResult {
    public InputValidationResult(Boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    private final Boolean isValid;
    private final String errorMessage;

    public Boolean getValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
