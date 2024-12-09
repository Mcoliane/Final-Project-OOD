package Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerComponent {
    private List<String> parts = new ArrayList<>();

    @Override
    public void addPart(String part) {
        parts.add(part);
    }

    @Override
    public List<String> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Computer Parts: " + parts.toString();
    }
}
