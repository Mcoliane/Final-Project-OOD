package groupproject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        try {
            // Parse the CSV file
            CSVParser parser = new CSVParser("computerParts.csv");
            List<Map<String, String>> computersData = parser.getComputerData();

            // Build computers from the CSV data
            for (Map<String, String> data : computersData) {
                ComputerBuilder builder = new CSVToComputerBuilderAdapter(data);

                builder.Processor();
                builder.Graphics();
                builder.Motherboard();
                builder.PowerSupply();
                builder.Storage();
                builder.Memory();

                // Get and assemble the computer
                Computer computer = builder.getComputer();
                computer.AssemblePC(computer);
                System.out.println("----------");
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
