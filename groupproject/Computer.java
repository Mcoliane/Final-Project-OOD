package groupproject;

public class Computer {
    private Processor processor;
    private Motherboard motherboard;
    private Storage storage;
    private PowerSupply powerSupply;
    private GraphicsCard graphicsCard;
    private Memory memory;

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setGraphics(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Processor getProcessor() {
        return processor;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public Storage getStorage() {
        return storage;
    }

public void AssemblePC(Computer computer) {
    System.out.println("Display computer information:");
    System.out.println("\n Processor: ");
    System.out.println("\n Graphics Card: ");
    System.out.println("\n Motherboard: ");
    System.out.println("\n Power Supply: ");
    System.out.println("\n Storage: ");
    System.out.println("\n Computer Assembled Successfully");
    }
}
