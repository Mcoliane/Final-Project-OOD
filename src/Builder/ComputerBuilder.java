package Builder;

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
