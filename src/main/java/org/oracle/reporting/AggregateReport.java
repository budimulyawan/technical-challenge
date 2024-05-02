package org.oracle.reporting;

import org.oracle.aggregators.Aggregator;

import java.util.ArrayList;
import java.util.List;

public class AggregateReport<T> implements Report {
    private final List<Aggregator> aggregatorList;
    private String description;


    public AggregateReport(String description) {
        this.aggregatorList =  new ArrayList<>();
    }

    public void addAggregators(Aggregator aggregators) {
        this.aggregatorList.add(aggregators);
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getReportBody() {
        StringBuilder builder = new StringBuilder();
        for(Aggregator aggregator: aggregatorList) {
            builder.append(aggregator.getResult());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
