package de.exxcellent.challenge.weathertest;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.weather.WeatherReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherReaderTest {
    private static WeatherReader weatherReader;


    @BeforeEach
    void setUp() {
        weatherReader = new WeatherReader("weather.csv");
    }

    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }

    @Test
    void getDayWithSmallestTempSpread() {
        String minDeltaDay = weatherReader.getDayWithSmallestTempSpread();
        assertEquals("14", minDeltaDay, "My expectations were not met");
    }

    @AfterEach
    void tearDown() {
        weatherReader = null;
    }
}