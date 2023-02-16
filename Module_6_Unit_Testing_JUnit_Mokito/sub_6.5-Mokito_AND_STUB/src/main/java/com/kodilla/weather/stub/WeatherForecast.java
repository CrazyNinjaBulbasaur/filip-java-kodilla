package com.kodilla.weather.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public double calculateMedianTemperature() {
        double median = 0;
        ArrayList<Double> list = new ArrayList<>();


/*** Old iteration iterating through Entryset

    for(Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()){
        list.add(entry.getValue());
    }
*/

/*** New Iteration. Optimizing by iterating only through values

    for(Double entry : temperatures.getTemperatures().values()){
        list.add(entry);
    }
 */

/**
 * * Using a method provided by List for bulk operation.
 */
        list.addAll(temperatures.getTemperatures().values());

        Collections.sort(list);
//        System.out.println(list);
//        System.out.println(list.get(list.size()/2));

        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        } else {
            median = list.get(list.size() / 2);
        }

        return median;
    }

    public double calculateAverageTemperature() {
        double sum = 0;
        double average;

        for(Double value : temperatures.getTemperatures().values()){
            sum += value;
        }

//        for (Map.Entry<String, Double> temperature :
//                temperatures.getTemperatures().entrySet()) {
//            sum += temperature.getValue();
//        }
        average = sum / temperatures.getTemperatures().size();

        return average;
    }


    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
}
