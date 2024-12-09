package Adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    private String filePath;
    private ArrayList<String[]> rows = new ArrayList<>();

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public void load() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                // Expecting CSV in format: Category,PartName
                // e.g. CPU,Intel Core i7
                rows.add(line.split(","));
            }
        }
    }

    public ArrayList<String[]> getRows() {
        return rows;
    }
}
