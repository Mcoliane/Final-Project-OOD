package decorator;

import Builder.ComputerComponent;

public class MonitorDecorator extends ComputerDecorator {
    public MonitorDecorator(ComputerComponent decoratedComputer) {
        super(decoratedComputer);
        addMonitor();
    }

    private void addMonitor() {
        addPart("Monitor");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
