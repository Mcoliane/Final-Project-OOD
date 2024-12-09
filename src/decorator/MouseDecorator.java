package decorator;

import Builder.ComputerComponent;

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
