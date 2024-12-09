package groupproject;

public class KeyboardAndMouseDecorator extends ComputerDecorator {
    public KeyboardAndMouseDecorator(ComputerInterface computerInterface) {
        super(computerInterface);
    }

    @Override
    public double getCost() {
        return computerInterface.getCost() + 50;
    }

    @Override
    public void AssemblePC(ComputerInterface computer) {
        computerInterface.AssemblePC(computer);
        this.add("Keyboard and Mouse");
    }

    @Override
    public void add(String component) {
        computerInterface.add(component);
    }

    @Override
    public void setProcessor(Processor processor) {
        computerInterface.setProcessor(processor);
    }

    @Override
    public void setGraphics(GraphicsCard graphicsCard) {
        computerInterface.setGraphics(graphicsCard);
    }

    @Override
    public void setMotherboard(Motherboard motherboard) {
        computerInterface.setMotherboard(motherboard);
    }

    @Override
    public void setPowerSupply(PowerSupply powerSupply) {
        computerInterface.setPowerSupply(powerSupply);
    }

    @Override
    public void setStorage(Storage storage) {
        computerInterface.setStorage(storage);
    }

    @Override
    public void setMemory(Memory memory) {
        computerInterface.setMemory(memory);
    }

    @Override
    public Processor getProcessor() {
        return computerInterface.getProcessor();
    }

    @Override
    public GraphicsCard getGraphicsCard() {
        return computerInterface.getGraphicsCard();
    }

    @Override
    public Motherboard getMotherboard() {
        return computerInterface.getMotherboard();
    }

    @Override
    public PowerSupply getPowerSupply() {
        return computerInterface.getPowerSupply();
    }

    @Override
    public Storage getStorage() {
        return computerInterface.getStorage();
    }

    @Override
    public Memory getMemory() {
        return computerInterface.getMemory();
    }
}