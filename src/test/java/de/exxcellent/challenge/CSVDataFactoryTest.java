package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CSVDataFactoryTest {
    @Test
    void parseEmptyCSV() throws Exception {
        File emptyCSV=TestUtils.getTestCSVFile("");
        assertThrows(InvalidCSVFormatException.class, () -> { CSVDataFactory.parse(emptyCSV); });
    }

    @Test
    void parseValidCSV_OneEntry() throws Exception {
            File csv=TestUtils.getTestCSVFile("Day\n1");
            List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
            expectedCSVObject.add(Map.of(
                "Day", "1"));

            assertEquals(expectedCSVObject,  CSVDataFactory.parse(csv));
    }

    @Test
    void parseInvalidCSV_noValue() throws Exception {
        File csv=TestUtils.getTestCSVFile("Day\n");
        assertThrows(InvalidCSVFormatException.class, () -> { CSVDataFactory.parse(csv); });
    }

    @Test
    void parseValidCSV_emptyValue() throws Exception {
        File csv=TestUtils.getTestCSVFile("Day\n ");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        expectedCSVObject.add(Map.of(
                "Day", " "));
        assertEquals(expectedCSVObject,  CSVDataFactory.parse(csv));
    }

    @Test
    void parseValidCSV_twoColumns() throws Exception {
        File csv=TestUtils.getTestCSVFile("Day,MxT\n1,2");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        expectedCSVObject.add(Map.of(
                "Day", "1",
                "MxT", "2"));
        assertEquals(expectedCSVObject,  CSVDataFactory.parse(csv));
    }

    @Test
    void parseInvalidCSV_fileDoesNotExit() throws Exception {
        File csv= new File("bla");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        assertThrows(IOException.class, () -> { CSVDataFactory.parse(csv); });
    }

    @Test
    void parseInvalidCSV_twoColumns_onlyOneValue() throws Exception {
        File csv=TestUtils.getTestCSVFile("Day,MxT\n1");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        assertThrows(InvalidCSVFormatException.class, () -> { CSVDataFactory.parse(csv); });
    }



}


