package decorator;

import Builder.ComputerComponent;

public class KeyboardDecorator extends ComputerDecorator {
    public KeyboardDecorator(ComputerComponent decoratedComputer) {
        super(decoratedComputer);
        addKeyboard();
    }

    private void addKeyboard() {
        addPart("Keyboard");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
