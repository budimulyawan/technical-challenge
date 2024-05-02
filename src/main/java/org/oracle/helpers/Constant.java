package org.oracle.helpers;

public class Constant {
    public static final String INPUT_PATTERN = "^(?<customerId>\\d+),(?<contractId>\\d+),(?<geoZone>[a-z_]+),(?<teamCode>\\w+),(?<projectCode>\\w+),(?<buildDuration>[0-9]+s)?$";
    public static final String CUSTOMER_ID = "customerId";
    public static final String CONTRACT_ID = "contractId";
    public static final String GEO_ZONE = "geoZone";
    public static final String TEAM_CODE = "teamCode";
    public static final String PROJECT_CODE = "projectCode";
    public static final String BUILD_DURATION = "buildDuration";
}
