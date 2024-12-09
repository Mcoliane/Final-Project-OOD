package Adapter;

import java.util.ArrayList;
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

    private List<String> filterByCategory(String category) {
        List<String> result = new ArrayList<>();
        for (String[] row : csvReader.getRows()) {
            if (row.length == 2 && row[0].trim().equalsIgnoreCase(category)) {
                result.add(row[1].trim());
            }
        }
        return result;
    }
}
