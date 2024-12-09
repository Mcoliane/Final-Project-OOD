package Decorator;

import java.util.List;

public class MouseAndKeyboardDecorator extends ComputerDecorator{
    public MouseAndKeyboardDecorator(ComputerInterface computer) {
        super(computer);
    }

    @Override
    public void addPart(String part) {
        super.addPart(part);
    }

    @Override
    public List<String> getParts() {
        List<String> parts = super.getParts();
        parts.add("Mouse");
        parts.add("Keyboard");
        return parts;
    }
}
