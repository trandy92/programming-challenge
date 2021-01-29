package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataFromCsvTest {
    private final static String TEST_WEATHER_DATA="src/test/resources/weather.csv";

    @Test
    void getWeatherDataFromCsv() throws IOException {
        try {
            WeatherData weatherData = new WeatherDataFromCsv(TEST_WEATHER_DATA);
            assertEquals( 30, weatherData.getNumberEntries());
            assertEquals( 1, weatherData.getDay(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
