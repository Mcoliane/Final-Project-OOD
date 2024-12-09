package Adapter;

import java.util.List;

public class CSVPartsAdapter implements PartsSource {
    private CSVReader csvReader;

    public CSVPartsAdapter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<String> getCPUs() {
        return filterByCategory("CPU");
    }

    @Override
    public List<String> getMemories() {
        return filterByCategory("Memory");
    }

    @Override
    public List<String> getStorages() {
        return filterByCategory("Storage");
    }

    @Override
    public List<String> getGraphicsCards() {
        return filterByCategory("GPU");
    }

    @Override
    public List<String> getOtherParts() {
        return filterByCategory("Other");
    }

    @Override
    public List<String> getMotherboards() {
        return filterByCategory("Motherboard");
    }

    @Override
    public List<String> getPSUs() {
        return filterByCategory("PSU");
    }

    private List<String> filterByCategory(String category) {
        return csvReader.getRows().stream()
                .filter(row -> row.length == 2 && row[0].trim().equalsIgnoreCase(category))
                .map(row -> row[1].trim())
                .toList();
    }
}
