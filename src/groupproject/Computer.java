package groupproject;

public class Computer implements ComputerInterface{
    private Processor processor;
    private GraphicsCard graphicsCard;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private Storage storage;
    private Memory memory;

    @Override
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    @Override
    public void setGraphics(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }
    @Override
    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }
    @Override
    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }
    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
    @Override
    public void setMemory(Memory memory) {
        this.memory = memory;
    }
    @Override
    public Processor getProcessor() {
        return processor;
    }
    @Override
    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }
    @Override
    public Motherboard getMotherboard() {
        return motherboard;
    }
    @Override
    public PowerSupply getPowerSupply() {
        return powerSupply;
    }
    @Override
    public Storage getStorage() {
        return storage;
    }
    @Override
    public Memory getMemory() {
        return memory;
    }

    @Override
    public double getCost() {
        return this.processor.getCost() + this.graphicsCard.getCost() + this.motherboard.getCost() + this.powerSupply.getCost() + this.storage.getCost() + this.memory.getCost();
    }

    @Override
    public void AssemblePC(ComputerInterface computer) {
        System.out.println("Display computer information:");
        System.out.println("\n Processor: " + computer.getProcessor().getName());
        System.out.println("\n Graphics Card: " + computer.getGraphicsCard().getName());
        System.out.println("\n Motherboard: " + computer.getMotherboard().getName());
        System.out.println("\n Power Supply: " + computer.getPowerSupply().getName());
        System.out.println("\n Storage: " + computer.getStorage().getName());
        System.out.println("\n Memory: " + computer.getMemory().getName());
        System.out.println("\n Computer Assembled Successfully");
    }

    @Override
    public void add(String component){
        System.out.println("Adding " + component + " to the computer");
    }
}
