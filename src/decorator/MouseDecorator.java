// Purpose: Concrete decorator class for adding a mouse to a computer.
// Author: Mark
package Decorator;

import Builder.ComputerComponent;

//MouseDecorator class that adds a mouse to the computer.
public class MouseDecorator extends ComputerDecorator {
    public MouseDecorator(ComputerComponent decoratedComputer) {
        super(decoratedComputer);
        addMouse();
    }

    private void addMouse() {
        addPart("Mouse");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
