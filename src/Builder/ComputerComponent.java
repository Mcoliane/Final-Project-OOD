package Builder;

import java.util.List;

public interface ComputerComponent {
    void addPart(String part);
    List<String> getParts();
    String toString();
}