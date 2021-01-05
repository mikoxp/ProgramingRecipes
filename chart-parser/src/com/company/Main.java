package com.company;

import com.company.chart.parser.ChartDataParser;
import com.company.chart.parser.ValueParser;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, List<Integer>> map = new HashMap();
        map.put("x", Arrays.asList(1, 2, 3));
        map.put("y", Arrays.asList(5, 6, 7));
        for (String k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
        ValueParser x= (object) -> {
           return object;
        };
        Map<String, List<Object>> fun = ChartDataParser.parse((Map)map,x);
        System.out.println("---------------------");
        for (String k : fun.keySet()) {
            System.out.println(k + " " + fun.get(k));
        }

    }

}
