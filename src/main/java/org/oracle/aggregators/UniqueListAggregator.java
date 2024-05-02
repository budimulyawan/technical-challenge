package org.oracle.aggregators;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueListAggregator <T1,T2> extends AbstractAggregator<T1, T2> {
    public UniqueListAggregator(String description) {
        super(description);
    }
    public HashMap<String,String> getResult() {
        HashMap<String, String> result = new HashMap<>();
        for (T1 field : keyValues.keySet()) {
            List<T2> values = keyValues.get(field);
            String uniqueValue = values
                    .stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            result.put(field.toString(), uniqueValue);
        }
        return result;
    }
}
