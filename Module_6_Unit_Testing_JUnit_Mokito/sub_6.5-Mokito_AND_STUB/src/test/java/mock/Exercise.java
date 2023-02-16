package mock;

import com.kodilla.weather.stub.Temperatures;
import com.kodilla.weather.stub.WeatherForecast;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Exercise {

    @Mock
    private Temperatures temperaturesMock;

    private Map<String, Double> temperaturesMap = new HashMap<>();

    @BeforeEach
    public void before(){
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }

    @AfterEach
    public void after(){
        temperaturesMap.clear();
    }


    @Test
    void testCalculateAverageTemperature(){
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double averageTemperature = weatherForecast.calculateAverageTemperature();

        //Then
        Assertions.assertEquals(25.56, averageTemperature);

    }

    @Test
    void testCalculateMedianTemperatureForEvenNumber(){
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        //Then
        Assertions.assertEquals(25.5, medianTemperature);

    }

    @Test
    void testCalculateMedianTemperatureForOddNumber(){
        //Given
        temperaturesMap.put("Katowice", 27.8);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double medianTemperature = weatherForecast.calculateMedianTemperature();
//        System.out.println(medianTemperature);

        //Then
        Assertions.assertEquals(25.8, medianTemperature);

    }

    @Test
    void testCalculateForecastWithMock() {
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
}
