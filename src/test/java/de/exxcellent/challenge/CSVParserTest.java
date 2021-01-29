package de.exxcellent.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CSVParserTest {
    @Test
    void parseEmptyCSV() throws Exception {
        File emptyCSV=getTestCSVFile("");
        assertThrows(InvalidCSVFormatException.class, () -> { CSVParser.parse(emptyCSV); });
    }

    @Test
    void parseValidCSV_OneEntry() throws Exception {
            File csv=getTestCSVFile("Day\n1");
            List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
            expectedCSVObject.add(Map.of(
                "Day", "1"));

            assertEquals(expectedCSVObject,  CSVParser.parse(csv));
    }

    @Test
    void parseInvalidCSV_noValue() throws Exception {
        File csv=getTestCSVFile("Day\n");
        assertThrows(InvalidCSVFormatException.class, () -> { CSVParser.parse(csv); });
    }

    @Test
    void parseValidCSV_emptyValue() throws Exception {
        File csv=getTestCSVFile("Day\n ");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        expectedCSVObject.add(Map.of(
                "Day", " "));
        assertEquals(expectedCSVObject,  CSVParser.parse(csv));
    }

    @Test
    void parseValidCSV_twoColumns() throws Exception {
        File csv=getTestCSVFile("Day,MxT\n1,2");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        expectedCSVObject.add(Map.of(
                "Day", "1",
                "MxT", "2"));
        assertEquals(expectedCSVObject,  CSVParser.parse(csv));
    }

    @Test
    void parseInvalidCSV_fileDoesNotExit() throws Exception {
        File csv= new File("bla");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        assertThrows(IOException.class, () -> { CSVParser.parse(csv); });
    }

    @Test
    void parseInvalidCSV_twoColumns_onlyOneValue() throws Exception {
        File csv=getTestCSVFile("Day,MxT\n1");
        List<Map<String, String>> expectedCSVObject= new ArrayList<Map<String,String>>();
        assertThrows(InvalidCSVFormatException.class, () -> { CSVParser.parse(csv); });
    }

    private File getTestCSVFile(String content) throws IOException {
        File file = File.createTempFile( "csvFile", "csv");
        FileWriter writer = new FileWriter(file);
        file.deleteOnExit();
        writer.write(content);
        writer.close();
        return file;
    }

}


