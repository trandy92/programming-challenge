package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherDataFromCsvTest {
    @Test
    void getWeatherDataFromCsv() throws IOException {
            File csv = TestUtils.getTestCSVFile("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\n1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
            WeatherData weatherData = new WeatherData(new CSVDataFactory(csv));
            assertEquals( 2, weatherData.getNumberEntries());
            assertEquals( 1, weatherData.getDay(0));
            assertEquals( 88, weatherData.getMxT(0));
            assertEquals( 59, weatherData.getMnT(0));
            assertEquals( 74, weatherData.getAvT(0));
            assertEquals( 53.8, weatherData.getAvDP(0),0.01);
            assertEquals( 0, weatherData.get1HrP_TPcpn(0));
            assertEquals(2, weatherData.getDayWithSmallestTemperatureSpread());
    }

    @Test
    void getWeatherDataFromCsv_invalidFormat() throws IOException {
        File csv = TestUtils.getTestCSVFile("WrongColumn,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\n1,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
        assertThrows(InvalidWeatherDataException.class, () -> { new WeatherData(new CSVDataFactory(csv)); });
    }

    @Test
    void getWeatherDataFromCsv_invalidTypeOfValue() throws IOException {
        File csv = TestUtils.getTestCSVFile("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\nwrongValue,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
        assertThrows(InvalidWeatherDataException.class, () -> { new WeatherData(new CSVDataFactory(csv)); });
    }

    @Test
    void getWeatherDataFromCsv_invalidTypeOfValue_dayIsFloatInsteadOfInteger() throws IOException {
        File csv = TestUtils.getTestCSVFile("Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP\n0.5,88,59,74,53.8,0,280,9.6,270,17,1.6,93,23,1004.5\n2,79,63,71,46.5,0,330,8.7,340,23,3.3,70,28,1004.5");
        assertThrows(InvalidWeatherDataException.class, () -> { new WeatherData(new CSVDataFactory(csv)); });
    }
}
