package org.oracle.aggregators;

import java.util.HashMap;
import java.util.List;

public class UniqueCountAggregator <T1,T2> extends AbstractAggregator<T1, T2> {
    public UniqueCountAggregator(String description) {
        super(description);
    }
    public HashMap<String,String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        for (T1 field : keyValues.keySet()) {
            List<T2> values = keyValues.get(field);
            long uniqueCount = values
                    .stream().distinct().count();
            result.put(field.toString(), String.valueOf(uniqueCount));
        }
        return result;
    }
}
