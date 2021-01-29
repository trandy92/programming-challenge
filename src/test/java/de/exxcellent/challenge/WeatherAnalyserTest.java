package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andreas Reichel
 */
class WeatherAnalyserTest {
    private final static String TEST_WEATHER_DATA="src/test/resources/weather.csv";
    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void getSmallestTemperatureSpread() {

        WeatherAnalyser weatherAnalyser = new WeatherAnalyser(TEST_WEATHER_DATA);
        assertEquals(weatherAnalyser.getDayWithSmallestTemperatureSpread(), 40);
    }

}