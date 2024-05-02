package org.oracle.parsers;

import org.oracle.data.CustomerProjectData;

import java.util.List;

public class InputParsingResult {
    private final List<CustomerProjectData> customerProjectList;
    private final int totalParsedInput;
    private final int totalSuccessfullyParsed;
    private final int totalErrorParsed;
    public InputParsingResult(List<CustomerProjectData> customerProjectList, int totalParsedInput, int totalSuccessfullyParsed, int totalErrorParsed) {
        this.customerProjectList = customerProjectList;
        this.totalParsedInput = totalParsedInput;
        this.totalSuccessfullyParsed = totalSuccessfullyParsed;
        this.totalErrorParsed = totalErrorParsed;
    }

    public List<CustomerProjectData> getCustomerProjectList() {
        return customerProjectList;
    }

    public int getTotalParsedInput() {
        return totalParsedInput;
    }

    public int getTotalSuccessfullyParsed() {
        return totalSuccessfullyParsed;
    }

    public int getTotalErrorParsed() {
        return totalErrorParsed;
    }

}
