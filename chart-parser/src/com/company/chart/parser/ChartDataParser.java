package com.company.chart.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartDataParser {

    public static Map<String, List<Object>> parse(Map<String, List<Object>> data, ValueParser valueParser) {
        Map<String, List<Object>> result = new HashMap();

        List<Object> labels = new ArrayList<>( data.keySet());
        List<List<Object>> values = new ArrayList<>();
        for (String key : data.keySet()) {
            int i = 0;
            for(Object o:data.get(key)){
                if (values.size()==i) {
                    values.add(new ArrayList<>());
                }
                values.get(i).add(valueParser.parse(o));
                i++;
            }

        }
        result.put("labels",labels);
        result.put("data",(List)values);
        return result;
    }
}
