//header:
/*uses the Adapter Design Pattern to adapt the CSVReader class to the PartsSource interface. 
The CSVPartsAdapter class implements the PartsSource interface and adapts the CSVReader 
to retrieving parts data. 

The adapter filters the CSV rows by category and returns a list of part names for each category. 
author: Michael
*/

 
package Adapter;

import java.util.List;


public class CSVPartsAdapter implements PartsSource {
    private CSVReader csvReader;
    //constructure 
    public CSVPartsAdapter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }
    //implementing the methods of the interface
    //getcpu
    @Override
    public List<String> getCPUs() {
        return filterByCategory("CPU");
    }
    //getmemories
    @Override
    public List<String> getMemories() {
        return filterByCategory("Memory");
    }
    //getstorages
    @Override
    public List<String> getStorages() {
        return filterByCategory("Storage");
    }
    //getgraphicscards
    @Override
    public List<String> getGraphicsCards() {
        return filterByCategory("GPU");
    }
    //getOtherParts
    @Override 
    public List<String> getOtherParts() {
        return filterByCategory("Other");
    }
    //getmotherboards
    @Override
    public List<String> getMotherboards() {
        return filterByCategory("Motherboard");
    }
    //get PSU
    @Override
    public List<String> getPSUs() {
        return filterByCategory("PSU");
    }
    //method to filter CSV rows by category
    private List<String> filterByCategory(String category) {
        return csvReader.getRows().stream()
                .filter(row -> row.length == 2 && row[0].trim().equalsIgnoreCase(category))
                .map(row -> row[1].trim())
                .toList();
    }
}
