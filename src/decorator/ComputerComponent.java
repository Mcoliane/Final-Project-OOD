// Purpose: Interface for ComputerComponent class.
//author: Mark
package Decorator;

import java.util.List;
//getParts() and getDescription() methods 
public interface ComputerComponent {
    List<String> getParts();
    String getDescription();
}
