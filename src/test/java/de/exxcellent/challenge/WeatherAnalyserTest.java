package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Andreas Reichel
 */
class WeatherAnalyserTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    @Test
    void getSmallestTemperatureSpread() throws IOException {
        File csv = TestUtils.getTestCSVFile("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\n1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
        WeatherAnalyser weatherAnalyser = new WeatherAnalyser(csv);
        assertEquals(2,weatherAnalyser.getDayWithSmallestTemperatureSpread());
    }

}