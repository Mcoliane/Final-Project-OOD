// Purpose: Abstract class for ComputerDecorator. it uses a decorator class to add peripherals 
//to the computer. (such as a keyboard, mouse, and monitor).
// Author: Mark
package Decorator;
import Builder.ComputerComponent;
import java.util.List;

//
public abstract class ComputerDecorator implements ComputerComponent { //decorator class
    protected ComputerComponent decoratedComputer;

    public ComputerDecorator(ComputerComponent decoratedComputer) {
        this.decoratedComputer = decoratedComputer;
    }

    @Override //this add the peripherals to the computer
    public void addPart(String part) {
        decoratedComputer.addPart(part);
    }

    @Override //this gets the peripherals for the computer
    public List<String> getParts() {
        return decoratedComputer.getParts();
    }

    @Override //this returns the computer with the peripherals
    public String toString() {
        return decoratedComputer.toString();
    }
}
