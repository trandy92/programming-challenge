package de.exxcellent.challenge;

import java.io.File;

/**

 * @author Andreas Reichel <andreas_reichel@online.de>
 */
public class WeatherAnalyser {
    private File weatherDataFile;
    WeatherAnalyser(String weatherDataFilePath)
    {
        weatherDataFile = new File(weatherDataFilePath);
    }
    public int getDayWithSmallestTemperatureSpread() {
        System.out.println(weatherDataFile.exists());
        return 0;
    }
}
