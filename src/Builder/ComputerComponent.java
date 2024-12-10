//header 
//This is the ComputerComponent interface that is implemented by the Computer class.
//Author: Thien
package Builder;

import java.util.List;

public interface ComputerComponent {
    void addPart(String part);
    List<String> getParts();
    String toString();
}