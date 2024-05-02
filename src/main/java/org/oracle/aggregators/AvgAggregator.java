package org.oracle.aggregators;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

public class AvgAggregator<T1,T2> extends AbstractAggregator<T1, T2> {

    public AvgAggregator(String description) {
        super(description);
    }

    public HashMap<String,String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        for (T1 field : keyValues.keySet()) {
            List<T2> values = keyValues.get(field);

            OptionalDouble average = values
                    .stream()
                    .mapToDouble(a -> a instanceof  Number ? ((Number) a).doubleValue() : 0)
                    .average();
            result.put(field.toString(), average.isPresent() ? String.valueOf(average.getAsDouble()):  "0");
        }
        return result;
    }
}
