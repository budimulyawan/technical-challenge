package org.oracle.aggregators;

import java.util.HashMap;

public interface Aggregator {
    String getDescription();
    HashMap<String,String> getResult();
    String getGroupByTitle();
    String getAggregateNameTitle();

}
