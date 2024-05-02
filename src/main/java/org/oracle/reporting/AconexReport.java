package org.oracle.reporting;

import org.oracle.aggregators.AvgAggregator;
import org.oracle.aggregators.UniqueCountAggregator;
import org.oracle.aggregators.UniqueListAggregator;
import org.oracle.data.CustomerProjectData;
import org.oracle.data.GeoZoneEnum;

import java.util.List;

public class AconexReport extends AggregateReport {
    public AconexReport(String description, List<CustomerProjectData> data) {
        super(description);

        UniqueCountAggregator<Integer, Integer> uniqueCountCustomerIdGroupByContractId
                = new UniqueCountAggregator<>("The number of unique customerId for each contractId",
                "Contract Id", "Customer Id Count");

        UniqueCountAggregator<GeoZoneEnum, Integer> uniqueCountCustomerIdGroupByGeoZone
                = new UniqueCountAggregator<>("The number of unique customerId for each geozone",
                "GeoZone", "Customer Id Count");

        AvgAggregator<GeoZoneEnum,Long> avgAggregator
                = new AvgAggregator<>("The average buildduration for each geozone",
                "GeoZone", "Average Build Duration");

        UniqueListAggregator<GeoZoneEnum, Integer> uniqueListCustomerIdGroupByGeoZone
                = new UniqueListAggregator<>("The list of unique customerId for each geozone",
                "GeoZone", "List Customer Id");

        this.addAggregators(uniqueCountCustomerIdGroupByContractId);
        this.addAggregators(uniqueCountCustomerIdGroupByGeoZone);
        this.addAggregators(avgAggregator);
        this.addAggregators(uniqueListCustomerIdGroupByGeoZone);

        data.forEach(d-> {
            uniqueCountCustomerIdGroupByContractId.addFieldValues(d.getContractId(),d.getCustomerId());
            uniqueCountCustomerIdGroupByGeoZone.addFieldValues(d.getGeoZoneEnum(),d.getCustomerId());
            avgAggregator.addFieldValues(d.getGeoZoneEnum(),d.getDuration().toSeconds());
            uniqueListCustomerIdGroupByGeoZone.addFieldValues(d.getGeoZoneEnum(),d.getCustomerId());
        });
    }
}
