package org.oracle.reportings;

import org.junit.jupiter.api.Test;
import org.oracle.parsers.CSVInputParser;
import org.oracle.parsers.InputParser;
import org.oracle.parsers.InputParsingResult;
import org.oracle.reporting.AconexReport;
import org.oracle.validators.CSVInputValidator;
import org.oracle.validators.InputValidator;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.oracle.helpers.Util.readLines;

public class TestAconexReport {
    @Test
    void testWithSampleFile_should_be_ok() throws IOException {
        String[] lines = readLines(getClass().getClassLoader().getResource("test.txt").getFile());
        InputValidator validator = new CSVInputValidator();
        InputParser parser = new CSVInputParser(validator);
        InputParsingResult result = parser.parse(lines);

        String reportDescription = "Aconex Technical Challenge Report";
        AconexReport report = new AconexReport(reportDescription,
                result.getCustomerProjectList());

        assertNotNull(report.getReportBody());
        assertEquals(reportDescription, report.getDescription());

        String reportBody = "The number of unique customerId for each contractId\n" +
                "2346            : 2\n" +
                "2345            : 3\n" +
                "\n" +
                "The number of unique customerId for each geozone\n" +
                "eu_west         : 2\n" +
                "us_west         : 2\n" +
                "us_east         : 1\n" +
                "\n" +
                "The average buildduration for each geozone\n" +
                "eu_west         : 4222.0\n" +
                "us_west         : 2216.0\n" +
                "us_east         : 3445.0\n" +
                "\n" +
                "The list of unique customerId for each geozone\n" +
                "eu_west         : 3244332, 3244132\n" +
                "us_west         : 1223456, 1233456\n" +
                "us_east         : 2343225\n" +
                "\n";
        assertEquals(reportBody.replace("\n", System.lineSeparator()), report.getReportBody());
    }
}
