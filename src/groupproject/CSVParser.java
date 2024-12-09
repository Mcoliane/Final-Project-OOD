package groupproject;

import java.io.*;
import java.util.*;

public class CSVParser {
    private List<Map<String, String>> computerData;

    public CSVParser(String csvFilePath) throws IOException {
        computerData = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
        String[] headers = br.readLine().split(",");
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Map<String, String> computer = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                computer.put(headers[i].trim(), values[i].trim());
            }
            computerData.add(computer);
        }
        br.close();
    }

    public List<Map<String, String>> getComputerData() {
        return computerData;
    }
}
