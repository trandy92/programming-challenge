package de.exxcellent.challenge;


import java.io.*;
import java.util.*;


public class WeatherDataFromCsv implements WeatherData {
    List<Map<String, String>> weatherData = new ArrayList<>();
    private final static Set<String> EXPECTED_HEADER_COLUMNS =Set.<String>of("Day","MxT","MnT","AvT","AvDP","1HrP TPcpn","PDir","AvSp","Dir","MxS","SkyC","MxR","Mn","R AvSLP");

    public WeatherDataFromCsv(File csvFile) throws IOException {
        weatherData = CSVParser.parse(csvFile);

        if(isValidFormat() == false)
        {
            throw new InvalidWeatherDataException("Format of weather data is not correct");
        }
    }

    private boolean isValidFormat()
    {
        //Maybe not a good idea to check every data for valid format
        for(Map<String,String> weatherDataEntry : weatherData)
        {
            try {
                Integer.parseInt(weatherDataEntry.get("Day"));
                Integer.parseInt(weatherDataEntry.get("MxT"));
                Integer.parseInt(weatherDataEntry.get("MnT"));
                Integer.parseInt(weatherDataEntry.get("AvT"));
                Float.parseFloat(weatherDataEntry.get("AvDP"));
                Integer.parseInt(weatherDataEntry.get("1HrP TPcpn"));
                Integer.parseInt(weatherDataEntry.get("PDir"));
                Float.parseFloat(weatherDataEntry.get("AvSp"));
                Integer.parseInt(weatherDataEntry.get("Dir"));
                Integer.parseInt(weatherDataEntry.get("MxS"));
                Float.parseFloat(weatherDataEntry.get("SkyC"));
                Integer.parseInt(weatherDataEntry.get("MxR"));
                Integer.parseInt(weatherDataEntry.get("Mn"));
                Float.parseFloat(weatherDataEntry.get("R AvSLP"));
            }catch(Exception ex)
            {
                return false;
            }
        }
        Set<String> headerColumns = weatherData.get(0).keySet();
        return EXPECTED_HEADER_COLUMNS.equals(headerColumns);
    }

    @Override
    public int getDay(int index) {
        return Integer.parseInt(weatherData.get(index).get("Day"));
    }

    @Override
    public int getMxT(int index) {
        return Integer.parseInt(weatherData.get(index).get("MxT"));
    }

    @Override
    public int getMnT(int index) {
        return Integer.parseInt(weatherData.get(index).get("MnT"));
    }

    @Override
    public int getAvT(int index) {
        return Integer.parseInt(weatherData.get(index).get("AvT"));
    }

    @Override
    public float getAvDP(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvDP"));
    }

    @Override
    public int get1HrP_TPcpn(int index) {
        return Integer.parseInt(weatherData.get(index).get("1HrP TPcpn"));
    }

    @Override
    public int getPDir(int index) {
        return Integer.parseInt(weatherData.get(index).get("PDir"));
    }

    @Override
    public float getAvSp(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvSp"));
    }

    @Override
    public int getDir(int index) {
        return Integer.parseInt(weatherData.get(index).get("Dir"));
    }

    @Override
    public int getMxS(int index) {
        return Integer.parseInt(weatherData.get(index).get("MxS"));
    }

    @Override
    public float getSkyC(int index) {
        return Float.parseFloat(weatherData.get(index).get("SkyC"));
    }

    @Override
    public int getMxR(int index) {
        return Integer.parseInt(weatherData.get(index).get("MxR"));
    }

    @Override
    public int getMn(int index) {
        return Integer.parseInt(weatherData.get(index).get("Mn"));
    }

    @Override
    public float getR_AvSLP(int index) {
        return Float.parseFloat(weatherData.get(index).get("AvSLP"));
    }

    @Override
    public int getNumberEntries() {
        return weatherData.size();
    }
}
