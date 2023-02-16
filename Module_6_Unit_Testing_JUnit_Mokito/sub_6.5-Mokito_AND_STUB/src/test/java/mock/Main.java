package mock;

import com.kodilla.weather.stub.TemperaturesStub;

import com.kodilla.weather.stub.WeatherForecast;

public class Main {
    public static void main(String[] args) {
        TemperaturesStub ts = new TemperaturesStub();
        WeatherForecast ws = new WeatherForecast(ts);

        System.out.println(ws.calculateMedianTemperature());
    }
}
