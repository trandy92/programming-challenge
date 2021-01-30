package de.exxcellent.challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class takes a CSV file and converts it to a Data Structure looking like this:
 * {0->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}},
 *  1->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}}
 * author: Andreas Reichel
 */
public class CSVDataFactory implements DataFactory {
    File csvFile;
    List<Map<String, String>> csvData;
    public CSVDataFactory(File file) throws IOException {
        File csvFile=file;
        csvData = parse(file);
    }
    @Override
    public List<Map<String, String>> getData() {
        return csvData;
    }

    public static List<Map<String, String>>  parse(File file) throws IOException {
        List<Map<String, String>> csvData = new ArrayList<Map<String, String>>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String headerLine = br.readLine();
        if(headerLine == null)
        {
            throw new InvalidCSVFormatException("Values have to be set");
        }
        String[] headerColumns = headerLine.split(",");
        String line = br.readLine();
        if(line == null)
        {
            throw new InvalidCSVFormatException("Values have to be set");
        }
        while (line != null) {
            String[] values = line.split(",");
            if(values.length != headerColumns.length)
            {
                throw new InvalidCSVFormatException("Values have to be set");
            }

            HashMap<String, String> csvEntry = new HashMap<String, String>();

            int columnIndex = 0;
            for (String value : values) {
                csvEntry.put(headerColumns[columnIndex], value);
                columnIndex++;
            }
            csvData.add(csvEntry);
            line = br.readLine();
        }
        return csvData;
    }
}
