package org.oracle.aggregators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractAggregator<T1, T2> implements Aggregator {
    protected final HashMap<T1, List<T2>> keyValues = new HashMap<>();

    private final String description;



    private final String groupByTitle;
    private final String aggregateNameTitle;

    public AbstractAggregator(String description, String groupByTitle, String aggregateNameTitle) {
        this.description = description;
        this.groupByTitle = groupByTitle;
        this.aggregateNameTitle = aggregateNameTitle;
    }

    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public String getGroupByTitle() {
        return groupByTitle;
    }
    @Override
    public String getAggregateNameTitle() {
        return aggregateNameTitle;
    }

    public void addFieldValues(T1 field, T2 value) {
        if (keyValues.containsKey(field)) {
            List<T2> values = keyValues.get(field);
            values.add(value);
        } else {
            List<T2> values = new ArrayList<>();
            values.add(value);
            keyValues.put(field, values);
        }
    }
}
