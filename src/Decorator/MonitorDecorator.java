package Decorator;

import java.util.List;

public class MonitorDecorator extends ComputerDecorator{
    public MonitorDecorator(ComputerInterface computer) {
        super(computer);
    }

    @Override
    public void addPart(String part) {
        super.addPart(part);
    }

    @Override
    public List<String> getParts() {
        List<String> parts = super.getParts();
        parts.add("Monitor");
        return parts;
    }
}
