package groupproject;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        try {
            // Parse the CSV file
            CSVParser parser = new CSVParser("C:\\Users\\Ryzen7\\Documents\\Final-Project-OODREAL\\src\\groupproject\\computerParts.csv");
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
        ComputerInterface computer = new Computer();
        computer.setGraphics(new GraphicsCard("NVIDIA GeForce RTX 3080", "NVIDIA", "RTX 3080", 699.99));
        computer.setMemory(new Memory("Corsair Vengeance LPX 16GB", "Corsair", "Vengeance LPX", 79.99));
        computer.setMotherboard(new Motherboard("ASUS ROG Strix Z490-E", "ASUS", "ROG Strix Z490-E", 299.99));
        computer.setPowerSupply(new PowerSupply("EVGA SuperNOVA 750 G5", "EVGA", "SuperNOVA 750 G5", 129.99));
        computer.setProcessor(new Processor("Intel Core i9-10900K", "Intel", "Core i9-10900K", 499.99));
        computer.setStorage(new Storage("Samsung 970 EVO Plus 1TB", "Samsung", "970 EVO Plus", 199.99));
        computer.AssemblePC((Computer) computer);
        computer = new KeyboardAndMouseDecorator(computer);
        computer.AssemblePC(computer);
        computer = new MonitorDecorator(computer);
        computer.AssemblePC(computer);

    }
}
