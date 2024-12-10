//header 
//This interface outlines the basic to get and add parts to make a computer.
//Author: Thien
package Builder;

import java.util.List;

public interface ComputerComponent {
    void addPart(String part);
    List<String> getParts();
    String toString();
}