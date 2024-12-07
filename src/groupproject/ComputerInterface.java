package groupproject;

public interface ComputerInterface {
    double getCost();
    void AssemblePC(ComputerInterface computer);
    void add(String component);
    void setProcessor(Processor processor);
    void setGraphics(GraphicsCard graphicsCard);
    void setMotherboard(Motherboard motherboard);
    void setPowerSupply(PowerSupply powerSupply);
    void setStorage(Storage storage);
    void setMemory(Memory memory);
    Processor getProcessor();
    GraphicsCard getGraphicsCard();
    Motherboard getMotherboard();
    PowerSupply getPowerSupply();
    Storage getStorage();
    Memory getMemory();
}