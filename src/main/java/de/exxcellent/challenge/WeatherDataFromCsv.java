package de.exxcellent.challenge;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class WeatherDataFromCsv implements WeatherData {
    List<HashMap<String,Float>> weatherData = new ArrayList<HashMap<String,Float>>();
    private final static String DATA_SEPERATOR=",";

    public WeatherDataFromCsv(String csvFile) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        try {
            String line = br.readLine();
            String[] headerTokens=  line.split(",");

            line = br.readLine();
            while (line != null){

                String[] values=  line.split(",");
                HashMap<String,Float> weatherDataEntry = new HashMap<String,Float>();

                int columnIndex = 0;

                for(String value : values)
                {
                    weatherDataEntry.put(headerTokens[columnIndex], Float.valueOf(value));
                    columnIndex++;
                }
                weatherData.add(weatherDataEntry);
                line = br.readLine();
                System.out.println("size "+ weatherData.size());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getDay(int indexEntry) {
        return weatherData.get(indexEntry).get("Day").intValue();
    }

    @Override
    public int getNumberEntries() {
        return weatherData.size();
    }
}
