//header:
/*uses the Adapter Design Pattern to adapt the CSVReader class to the PartsSource interface. 
The CSVPartsAdapter class implements the PartsSource interface and adapts the CSVReader 
to retrieving parts data. 

The adapter filters the CSV rows by category and returns a list of part names for each category. 
then the adapter allow csv 
author: Michael
*/

 
package Adapter;

import java.util.List;


public class CSVPartsAdapter implements PartsSource {
    private CSVReader csvReader;
    //constructor
    public CSVPartsAdapter(CSVReader csvReader) {
        this.csvReader = csvReader;
    }
    //implementing the methods of the interface
    //gets the cpu
    @Override
    public List<String> getCPUs() {
        return filterByCategory("CPU");
    }
    //gets the memories
    @Override
    public List<String> getMemories() {
        return filterByCategory("Memory");
    }
    //gets the storages
    @Override
    public List<String> getStorages() {
        return filterByCategory("Storage");
    }
    //gets the graphicscards
    @Override
    public List<String> getGraphicsCards() {
        return filterByCategory("GPU");
    }
    //gets the OtherParts
    @Override 
    public List<String> getOtherParts() {
        return filterByCategory("Other");
    }
    //gets the motherboards
    @Override
    public List<String> getMotherboards() {
        return filterByCategory("Motherboard");
    }
    //gets the power supply
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
