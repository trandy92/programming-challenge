package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;

/**
 * @author Andreas Reichel <andreas_reichel@online.de>
 */
public class WeatherAnalyser {
    WeatherData weatherData;
    WeatherAnalyser(DataFactory dataFactory) throws IOException {
         this.weatherData = new WeatherData(dataFactory);
    }
    public int getDayWithSmallestTemperatureSpread() {
        Integer dayWithSmallestTemperatureSpread=null;
        Float smallestTemperatureSpread = null;
        for (int i = 0; i < weatherData.getNumberEntries(); i++)
        {
            float temperatureSpread=weatherData.getMxT(i) - weatherData.getMnT(i);
            if(dayWithSmallestTemperatureSpread==null)
            {
                smallestTemperatureSpread=temperatureSpread;
                dayWithSmallestTemperatureSpread=weatherData.getDay(i);
            }else
            {
                if(temperatureSpread<=smallestTemperatureSpread)
                {
                    smallestTemperatureSpread=temperatureSpread;
                    dayWithSmallestTemperatureSpread=weatherData.getDay(i);
                }
            }
        }
        return dayWithSmallestTemperatureSpread;
    }
}
