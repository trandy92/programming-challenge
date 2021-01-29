package de.exxcellent.challenge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestUtils {
    public static File getTestCSVFile(String content) throws IOException {
        File file = File.createTempFile( "csvFile", "csv");
        FileWriter writer = new FileWriter(file);
        file.deleteOnExit();
        writer.write(content);
        writer.close();
        return file;
    }
}
