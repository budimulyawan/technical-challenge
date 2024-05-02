package org.oracle;

import org.oracle.parsers.CSVInputParser;
import org.oracle.parsers.InputParser;
import org.oracle.parsers.InputParsingResult;
import org.oracle.reporting.AconexReport;
import org.oracle.reporting.ConsoleReportViewer;
import org.oracle.validators.CSVInputValidator;
import org.oracle.validators.InputValidator;

import java.io.IOException;

import static org.oracle.helpers.Util.readLines;

public class Main {
    public static void main(String[] args) throws IOException {
        String file = Main.class.getClassLoader().getResource("test.txt").getFile();
        if (args.length != 0) {
            file = args[0];
        }
        String[] lines = readLines(file);
        InputValidator validator = new CSVInputValidator();
        InputParser parser = new CSVInputParser(validator);
        InputParsingResult result = parser.parse(lines);

        AconexReport report = new AconexReport("Aconex Technical Challenge Report",
                result.getCustomerProjectList());
        ConsoleReportViewer viewer = new ConsoleReportViewer();
        viewer.view(report);
    }
}