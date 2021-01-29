package de.exxcellent.challenge;


import java.util.HashMap;

public class WeatherDataFromCsv implements WeatherData {
    HashMap<String,Long> weatherData;
    public WeatherDataFromCsv(String csvFile)
    {

    }

    @Override
    public void getDay(int indexEntry) {

    }

    @Override
    public void getSize() {

    }

    @Override
    public int getNumberEntries() {
        return 0;
    }
}
