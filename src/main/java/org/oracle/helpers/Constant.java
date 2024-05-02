package org.oracle.helpers;

public class Constant {
    public static String INPUT_PATTERN = "^(?<customerId>\\d+),(?<contractId>\\d+),(?<geoZone>[a-z_]+),(?<teamCode>\\w+),(?<projectCode>\\w+),(?<buildDuration>[0-9]+s)?$";
    public static  String CUSTOMER_ID = "customerId";
    public static  String CONTRACT_ID = "contractId";
    public static  String GEO_ZONE = "geoZone";
    public static  String TEAM_CODE = "teamCode";
    public static  String PROJECT_CODE = "projectCode";
    public static  String BUILD_DURATION = "buildDuration";
}
