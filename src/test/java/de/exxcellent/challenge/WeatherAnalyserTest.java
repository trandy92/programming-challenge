package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andreas Reichel
 */
class WeatherAnalyserTest {

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
        WeatherAnalyser weatherAnalyser = new WeatherAnalyser("weather.csv");
        assertEquals(weatherAnalyser.getDayWithSmallestTemperatureSpread(), 40);
    }

}