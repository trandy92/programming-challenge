package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballDataTest {
    @Test
    void getFootballDataFromCsv() throws IOException {
        File csv = TestUtils.getTestCSVFile("Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points\nArsenal,38,26,9,3,79,36,87\nLiverpool,38,24,8,6,67,30,80\nManchester United,38,24,5,9,87,45,77");

        FootballData footballData = new FootballData(new CSVDataFactory(csv));

        assertEquals( 3, footballData.getNumberEntries());
        assertEquals("Liverpool", footballData.getTeamWithSmallestDifferenceBetweenGoalsAndGoalsAllowed());
        assertEquals("Arsenal", footballData.getTeam(0));
    }

    @Test
    void getFootballDataFromCsv_Goals_smaller_GoalsAllowed() throws IOException {
        File csv = TestUtils.getTestCSVFile("Team,Games,Wins,Losses,Draws,Goals,Goals Allowed,Points\nArsenal,38,26,9,3,79,36,87\nLiverpool,38,24,8,6,27,86,80\nManchester United,38,24,5,9,87,45,77");

        FootballData footballData = new FootballData(new CSVDataFactory(csv));

        assertEquals( 3, footballData.getNumberEntries());
        assertEquals("Manchester United", footballData.getTeamWithSmallestDifferenceBetweenGoalsAndGoalsAllowed());
    }
}
