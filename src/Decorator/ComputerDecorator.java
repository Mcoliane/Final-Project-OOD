package Decorator;

import java.util.List;

public class ComputerDecorator implements ComputerInterface{
    private ComputerInterface computer;

    public ComputerDecorator(ComputerInterface computer) {
        this.computer = computer;
    }

    @Override
    public void addPart(String part) {
        computer.addPart(part);
    }

    @Override
    public List<String> getParts() {
        return computer.getParts();
    }
}
