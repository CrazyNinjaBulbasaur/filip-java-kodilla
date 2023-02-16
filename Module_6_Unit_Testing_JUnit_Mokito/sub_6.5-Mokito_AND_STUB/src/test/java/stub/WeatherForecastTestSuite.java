package stub;

import com.kodilla.weather.stub.Temperatures;
import com.kodilla.weather.stub.TemperaturesStub;
import com.kodilla.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {

        @Test
        void testCalculateForecastWithStub() {
            //Given
//          Temperatures temperatures = null; // TODO produkty                   // [1]
            Temperatures temperatures = new TemperaturesStub();                     // [1]
            WeatherForecast weatherForecast = new WeatherForecast(temperatures);    // [2]

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(5, quantityOfSensors);
        }
}
