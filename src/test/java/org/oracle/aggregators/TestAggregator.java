package org.oracle.aggregators;

import org.junit.jupiter.api.Test;
import org.oracle.data.CustomerProjectData;
import org.oracle.data.GeoZoneEnum;
import org.oracle.parsers.CSVInputParser;
import org.oracle.parsers.InputParser;
import org.oracle.parsers.InputParsingResult;
import org.oracle.validators.CSVInputValidator;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.oracle.helpers.Util.readLines;

public class TestAggregator {
    InputParsingResult setup() throws IOException {
        String[] input = readLines(getClass().getClassLoader().getResource("test.txt").getFile());
        CSVInputValidator validator = new CSVInputValidator();
        InputParser csvParser = new CSVInputParser(validator);
        return csvParser.parse(input);
    }

    @Test
    void testAverageSuccessResult() throws IOException {
        InputParsingResult inputParsingResult = setup();

        AvgAggregator<String, Long> avgAggregator = new AvgAggregator<>("Average duration for each GeoZone");
        for (CustomerProjectData data : inputParsingResult.getCustomerProjectList()) {
            avgAggregator.addFieldValues(data.getGeoZoneEnum().toString(), data.getDuration().toSeconds());
        }
        HashMap<String, String> avgResult = avgAggregator.getResult();
        assertNotNull(avgResult);
        assertEquals(3, avgResult.size());

        // TODO:  might want to check whether calculation is correct here
    }

    @Test
    void testUniqueListSuccessResult() throws IOException {
        InputParsingResult inputParsingResult = setup();

        UniqueListAggregator<String, Integer> avgAggregator = new UniqueListAggregator<>("The list of unique customerId for each geozone");
        for (CustomerProjectData data : inputParsingResult.getCustomerProjectList()) {
            avgAggregator.addFieldValues(data.getGeoZoneEnum().toString(), data.getCustomerId());
        }
        HashMap<String, String> aggregatorResult = avgAggregator.getResult();
        assertNotNull(aggregatorResult);
        assertEquals(3, aggregatorResult.size());
        assertTrue(aggregatorResult.get(GeoZoneEnum.us_east.toString()).contains("2343225"));
        assertFalse(aggregatorResult.get(GeoZoneEnum.us_east.toString()).contains("1223456"));
        assertEquals(2, aggregatorResult.get(GeoZoneEnum.eu_west.toString()).split(",").length);
    }

    @Test
    void testUniqueCountSuccessResult() throws IOException {
        InputParsingResult inputParsingResult = setup();

        UniqueCountAggregator<String, Integer> avgAggregator = new UniqueCountAggregator<>("The unique count of customerId for each geozone");
        for (CustomerProjectData data : inputParsingResult.getCustomerProjectList()) {
            avgAggregator.addFieldValues(data.getGeoZoneEnum().toString(), data.getCustomerId());
        }
        HashMap<String, String> aggregatorResult = avgAggregator.getResult();
        assertNotNull(aggregatorResult);
        assertEquals(3, aggregatorResult.size());
        assertEquals("1", aggregatorResult.get(GeoZoneEnum.us_east.toString()));
        assertEquals("2", aggregatorResult.get(GeoZoneEnum.us_west.toString()));
    }

    @Test
    void testUniqueCountWithDuplicateSuccessResult() throws IOException {
        InputParsingResult inputParsingResult = setup();

        UniqueCountAggregator<String, Integer> avgAggregator = new UniqueCountAggregator<>("The unique count of customerId for each geozone");
        for (CustomerProjectData data : inputParsingResult.getCustomerProjectList()) {
            avgAggregator.addFieldValues(data.getGeoZoneEnum().toString(), data.getCustomerId());
        }
        // we duplicate the input
        for (CustomerProjectData data : inputParsingResult.getCustomerProjectList()) {
            avgAggregator.addFieldValues(data.getGeoZoneEnum().toString(), data.getCustomerId());
        }
        HashMap<String, String> aggregatorResult = avgAggregator.getResult();
        assertNotNull(aggregatorResult);
        assertEquals(3, aggregatorResult.size());
        assertEquals("1", aggregatorResult.get(GeoZoneEnum.us_east.toString()));
        assertEquals("2", aggregatorResult.get(GeoZoneEnum.us_west.toString()));
    }
}
