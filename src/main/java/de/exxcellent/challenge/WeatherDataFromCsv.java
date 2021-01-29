package de.exxcellent.challenge;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WeatherDataFromCsv implements WeatherData {
    List<Map<String, String>> weatherData = new ArrayList<>();
    private final static String DATA_SEPERATOR=",";

    public WeatherDataFromCsv(String csvFile) throws IOException {
        weatherData = CSVParser.parse(new File(csvFile));
    }

    @Override
    public int getDay(int indexEntry) {
        return Integer.getInteger(weatherData.get(indexEntry).get("Day"));
    }

    @Override
    public int getNumberEntries() {
        return weatherData.size();
    }
}
