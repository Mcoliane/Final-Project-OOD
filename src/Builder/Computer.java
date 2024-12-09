package Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<String> parts = new ArrayList<>();

    public void addPart(String part) {
        parts.add(part);
    }

    public List<String> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Computer Parts: " + parts.toString();
    }
}
