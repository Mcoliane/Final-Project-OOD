// header: Implement the ComputerBuilder interface to build a computer.
//author: Thien
package Builder;

public class ConcreteComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public ConcreteComputerBuilder() {
        reset();
    }

    @Override
    public void reset() {
        computer = new Computer();
    }

    @Override
    public void addCPU(String cpu) {
        computer.addPart("CPU: " + cpu);
    }

    @Override
    public void addMemory(String memory) {
        computer.addPart("Memory: " + memory);
    }

    @Override
    public void addStorage(String storage) {
        computer.addPart("Storage: " + storage);
    }

    @Override
    public void addGraphicsCard(String gpu) {
        computer.addPart("GPU: " + gpu);
    }

    @Override
    public void addOtherPart(String part) {
        computer.addPart(part);
    }

    @Override
    public void addMotherboard(String motherboard) {
        computer.addPart("Motherboard: " + motherboard);
    }

    @Override
    public void addPSU(String psu) {
        computer.addPart("PSU: " + psu);
    }

    @Override
    public Computer getResult() {
        return computer;
    }
}
