//Header: Interface for the ComputerBuilder class.
//it defines the requirement to build a computer
//author: Thien
package Builder;
//all the methods required to build a computer
public interface ComputerBuilder {
    void reset();
    void addCPU(String cpu);
    void addMemory(String memory);
    void addStorage(String storage);
    void addGraphicsCard(String gpu);
    void addOtherPart(String part);
    void addMotherboard(String motherboard);
    void addPSU(String psu);

    Computer getResult();
}
