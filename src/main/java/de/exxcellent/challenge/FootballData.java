package de.exxcellent.challenge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FootballData {
    List<Map<String, String>> footballData = new ArrayList<>();
    private final static Set<String> EXPECTED_HEADER_COLUMNS =Set.<String>of("Team","Games","Wins","Losses","Draws","Goals","Goals Allowed","Points");

    public FootballData(DataFactory dataFactory) throws IOException {
        footballData = dataFactory.getData();

        if(isValidFormat() == false)
        {
            throw new InvalidFootballDataException("Format of weather data is incorrect");
        }
    }

    private boolean isValidFormat()
    {
        try {
            //Maybe not a good idea to check every data entry for valid format
            for(Map<String,String> footballDataEntry : footballData) {
                for (Map.Entry<String, String> entry : footballDataEntry.entrySet()) {
                    if (!entry.getKey().equals("Team")) {
                        Integer.parseInt(entry.getValue());
                    }
                }
            }
        }catch(Exception ex)
        {
            return false;
        }

        Set<String> headerColumns = footballData.get(0).keySet();
        return EXPECTED_HEADER_COLUMNS.equals(headerColumns);
    }

    public int getNumberEntries() {
        return footballData.size();
    }

    public String getTeam(int index)
    {
        return footballData.get(index).get("Team");
    }

    public String getTeamWithSmallestDifferenceBetweenGoalsAndGoalsAllowed()
    {
        int index = DataAnalyser.getEntryWithSmallestSpread(footballData,"Goals", "Goals Allowed");

        return getTeam(index);
    }
}
