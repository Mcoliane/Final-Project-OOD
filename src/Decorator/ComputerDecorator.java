package decorator;

import Builder.ComputerComponent;

import java.util.List;

public abstract class ComputerDecorator implements ComputerComponent {
    protected ComputerComponent decoratedComputer;

    public ComputerDecorator(ComputerComponent decoratedComputer) {
        this.decoratedComputer = decoratedComputer;
    }

    @Override
    public void addPart(String part) {
        decoratedComputer.addPart(part);
    }

    @Override
    public List<String> getParts() {
        return decoratedComputer.getParts();
    }

    @Override
    public String toString() {
        return decoratedComputer.toString();
    }
}
