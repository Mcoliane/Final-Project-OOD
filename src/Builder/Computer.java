package Builder;

import Decorator.ComputerInterface;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerInterface {
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
