// Purpose: KeyboardDecorator class for Decorator pattern.
// author: Mark
package Decorator;

import Builder.ComputerComponent;

//KeyboardDecorator class that adds a keyboard to the computer.
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
