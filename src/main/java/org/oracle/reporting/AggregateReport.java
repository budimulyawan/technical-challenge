package org.oracle.reporting;

import org.oracle.aggregators.Aggregator;

import java.util.ArrayList;
import java.util.List;

public class AggregateReport implements Report {
    private final List<Aggregator> aggregatorList;
    private final String description;

    public AggregateReport(String description) {
        this.description = description;
        this.aggregatorList =  new ArrayList<>();
    }

    protected void addAggregators(Aggregator aggregators) {
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
            builder.append(aggregator.getDescription());
            builder.append(System.lineSeparator());
            builder.append(String.format("%-15s : %s%n", aggregator.getGroupByTitle(), aggregator.getAggregateNameTitle()));
            aggregator.getResult().forEach((k, v) -> builder.append(String.format("%-15s : %s%n", k, v)));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

}
