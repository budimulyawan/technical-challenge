package org.oracle.parsers;

import org.oracle.data.CustomerProjectData;
import org.oracle.data.GeoZoneEnum;
import org.oracle.helpers.Constant;
import org.oracle.validators.InputValidationResult;
import org.oracle.validators.InputValidator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVInputParser implements  InputParser{

    private final InputValidator inputValidator;

    public CSVInputParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public InputParsingResult parse(String[] input) {
        int numberOfErrorLine = 0;
        int numberOfSuccessfullyParsedLine = 0;
        ArrayList<CustomerProjectData> customerProjectList = new ArrayList<>();
        if (input == null) return new InputParsingResult(customerProjectList, 0, numberOfSuccessfullyParsedLine,numberOfErrorLine);

        for (String line : input) {
            InputValidationResult validationResult = inputValidator.validate(line);
            if (!validationResult.getValid()) {
                numberOfErrorLine++;
                continue;
            }
            Pattern pattern = Pattern.compile(Constant.INPUT_PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {

                String customerId = matcher.group(Constant.CUSTOMER_ID);
                String contractId = matcher.group(Constant.CONTRACT_ID);
                String geoZone = matcher.group(Constant.GEO_ZONE);
                String projectCode = matcher.group(Constant.PROJECT_CODE);
                String teamCode = matcher.group(Constant.TEAM_CODE);
                String buildDuration = matcher.group(Constant.BUILD_DURATION);

                CustomerProjectData customerProjectData = new CustomerProjectData();
                customerProjectData.setCustomerId(Integer.parseInt(customerId));
                customerProjectData.setContractId(Integer.parseInt(contractId));
                customerProjectData.setGeoZoneEnum(GeoZoneEnum.valueOf(geoZone));
                customerProjectData.setProjectCode(projectCode);
                customerProjectData.setTeamCode(teamCode);
                customerProjectData.setDuration(Duration.parse("PT" + buildDuration));
                customerProjectList.add(customerProjectData);
                numberOfSuccessfullyParsedLine++;
            } else {
                numberOfErrorLine++;
            }
        }
        return new InputParsingResult(customerProjectList, input.length, numberOfSuccessfullyParsedLine, numberOfErrorLine);
    }
}
