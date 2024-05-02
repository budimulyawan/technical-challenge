package org.oracle.validators;

public class InputValidationResult {
    public InputValidationResult(Boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    private Boolean isValid;
    private String errorMessage;

    public Boolean getValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
