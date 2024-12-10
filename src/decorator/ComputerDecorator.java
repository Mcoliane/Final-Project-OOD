// Purpose: Abstract class for ComputerDecorator. it uses a decorator pattern to add peripherals 
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

    @Override //this add the peripherals as an option for the computer
    public void addPart(String part) {
        decoratedComputer.addPart(part);
    }

    @Override //gets the peripherals 
    public List<String> getParts() {
        return decoratedComputer.getParts();
    }

    @Override //this returns the string argument containing the peripherals 
    public String toString() {
        return decoratedComputer.toString();
    }
}
