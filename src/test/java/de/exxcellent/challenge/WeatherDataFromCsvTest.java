package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherDataFromCsvTest {
    private final static String TEST_WEATHER_DATA="src/test/resources/weather.csv";

    @Test
    void getWeatherDataFromCsv() {

        WeatherData weatherData = new WeatherDataFromCsv(TEST_WEATHER_DATA);
        assertEquals(weatherData.getNumberEntries(), 30);
    }
}
