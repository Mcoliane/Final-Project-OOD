//header
//responsible for reading and parsing a CSV file containing rows of computer parts categorized by type
//author: Michael 
package Adapter;
//importing the required libraries
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//CSVReader class
public class CSVReader {
    private String filePath; //file path to be read
    //arraylist to store the rows of the csv file
    private ArrayList<String[]> rows = new ArrayList<>();
    //constructor
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }
    //method to load the csv file
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
    //getter method to get the rows
    public ArrayList<String[]> getRows() {
        return rows;
    }
}
