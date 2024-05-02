package org.oracle.data;

import java.time.Duration;

public class CustomerProjectData {
    private int customerId;
    private int contractId;
    private GeoZoneEnum geoZoneEnum;
    private String teamCode;
    private String projectCode;
    private Duration duration;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public GeoZoneEnum getGeoZoneEnum() {
        return geoZoneEnum;
    }

    public void setGeoZoneEnum(GeoZoneEnum geoZoneEnum) {
        this.geoZoneEnum = geoZoneEnum;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
