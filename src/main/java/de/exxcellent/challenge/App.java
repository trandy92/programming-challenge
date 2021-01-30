package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        try
        {
            String domain=args[0];
            if(!domain.equals("--weather") && !domain.equals("--football"))
            {
                System.err.printf("%s is not a valid option",domain);
            }
            
            File csvFile=new File(args[1]);
            DataFactory dataFactory = new CSVDataFactory(csvFile);

            if(domain.equals("--weather"))
            {
                WeatherData weatherData = new WeatherData(dataFactory);
                Integer dayWithSmallestTempSpread = weatherData.getDayWithSmallestTemperatureSpread();     // Your day analysis function call …
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }
            if(domain.equals("--football"))
            {
                FootballData footballData = new FootballData(dataFactory);
                String teamWithSmallestGoalSpread = footballData.getTeamWithSmallestDifferenceBetweenGoalsAndGoalsAllowed(); // Your goal analysis function call …
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
            }
        } catch (IOException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
    }
}
