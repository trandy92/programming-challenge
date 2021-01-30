package de.exxcellent.challenge;


import java.io.*;
import java.util.*;


public class WeatherData{
    List<Map<String, String>> weatherData = new ArrayList<>();
    private final static Set<String> EXPECTED_HEADER_COLUMNS =Set.<String>of("Day","MxT","MnT","AvT","AvDP","1HrP TPcpn","PDir","AvSp","Dir","MxS","SkyC","MxR","Mn","R AvSLP");

    public WeatherData(DataFactory dataFactory) throws IOException {
        weatherData = dataFactory.getData();

        if(isValidFormat() == false)
        {
            throw new InvalidWeatherDataException("Format of weather data is incorrect");
        }
    }

    private boolean isValidFormat()
    {
        try {
            //Maybe not a good idea to check every data entry for valid format
            for(Map<String,String> weatherDataEntry : weatherData) {
                for (Map.Entry<String, String> entry : weatherDataEntry.entrySet()) {
                    if (entry.getKey().equals("Day")) {
                        Integer.parseInt(entry.getValue());
                    } else {
                        Float.parseFloat(entry.getValue());
                    }
                }
            }
        }catch(Exception ex)
        {
            return false;
        }

        Set<String> headerColumns = weatherData.get(0).keySet();
        return EXPECTED_HEADER_COLUMNS.equals(headerColumns);
    }

    public int getDay(int index) {
        return Integer.parseInt(weatherData.get(index).get("Day"));
    }

    public float getMxT(int index) {
        return Float.parseFloat(weatherData.get(index).get("MxT"));
    }

    public float getMnT(int index) {
        return Float.parseFloat(weatherData.get(index).get("MnT"));
    }

    public float getAvT(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvT"));
    }

    public float getAvDP(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvDP"));
    }

    public float get1HrP_TPcpn(int index) {
        return Float.parseFloat(weatherData.get(index).get("1HrP TPcpn"));
    }

    public float getPDir(int index) {
        return Float.parseFloat(weatherData.get(index).get("PDir"));
    }

    public float getAvSp(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvSp"));
    }

    public float getDir(int index) {
        return Float.parseFloat(weatherData.get(index).get("Dir"));
    }

    public float getMxS(int index) {
        return Float.parseFloat(weatherData.get(index).get("MxS"));
    }

    public float getSkyC(int index) {
        return Float.parseFloat(weatherData.get(index).get("SkyC"));
    }

    public float getMxR(int index) {
        return Float.parseFloat(weatherData.get(index).get("MxR"));
    }

    public float getMn(int index) {
        return Float.parseFloat(weatherData.get(index).get("Mn"));
    }

    public float getR_AvSLP(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvSLP"));
    }

    public int getNumberEntries() {
        return weatherData.size();
    }
}
