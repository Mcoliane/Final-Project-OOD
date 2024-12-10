// header: Implement the ComputerBuilder interface to build a computer.
// add parts to a computer concrete object.
//author: Thien
package Builder;

public class ConcreteComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public ConcreteComputerBuilder() {
        reset();
    }
    //reset the list to make a computer
    @Override
    public void reset() {
        computer = new Computer();
    }
    //add CPU to the list 
    @Override
    public void addCPU(String cpu) {
        computer.addPart("CPU: " + cpu);
    }
    //add memory to the list
    @Override
    public void addMemory(String memory) {
        computer.addPart("Memory: " + memory);
    }
    //add storage to the list
    @Override
    public void addStorage(String storage) {
        computer.addPart("Storage: " + storage);
    }
    //add GPU to the list
    @Override
    public void addGraphicsCard(String gpu) {
        computer.addPart("GPU: " + gpu);
    } 
    //add other parts to the list
    @Override
    public void addOtherPart(String part) {
        computer.addPart(part);
    }
    //add motherboard to the list
    @Override
    public void addMotherboard(String motherboard) {
        computer.addPart("Motherboard: " + motherboard);
    } 
    //add PSU to the list
    @Override
    public void addPSU(String psu) {
        computer.addPart("PSU: " + psu);
    }
    //get the result of the computer with all the parts that were added
    @Override
    public Computer getResult() {
        return computer;
    }
}
