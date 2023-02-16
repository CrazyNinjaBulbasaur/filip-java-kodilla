package mock;

import com.kodilla.weather.stub.Temperatures;
import com.kodilla.weather.stub.WeatherForecast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherForecastTestSuite {                                              // [7]
/** will not work as mock has no values
    @Test                                                                      // [8]
    void testCalculateForecastWithMock() {                                     // [9]
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);               // [10]
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);// [11]

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();     // [12]

        //Then
        Assertions.assertEquals(5, quantityOfSensors);                          // [13]
    }
*/

    @Test                                                                         // [11]
    void testCalculateForecastWithMockWithValues() {                                        // [12]
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);                   // [13]

        Map<String, Double> temperaturesMap = new HashMap<>();                     // [14]
        temperaturesMap.put("Rzeszow", 25.5);                                      // [15]
        temperaturesMap.put("Krakow", 26.2);                                       // [16]
        temperaturesMap.put("Wroclaw", 24.8);                                      // [17]
        temperaturesMap.put("Warszawa", 25.2);                                     // [18]
        temperaturesMap.put("Gdansk", 26.1);                                       // [19]

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);      // [20]

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);   // [21]

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();        // [22]

        //Then
        Assertions.assertEquals(5, quantityOfSensors);                             // [23]
    }
}
