// Purpose: Concrete decorator class that adds a monitor to the computer.
// Author: Mark
package Decorator;

import Builder.ComputerComponent;
//MonitorDecorator class that adds a monitor to the computer.
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
