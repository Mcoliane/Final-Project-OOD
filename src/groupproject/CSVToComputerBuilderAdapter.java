package groupproject;

import java.util.Map;

public class CSVToComputerBuilderAdapter implements ComputerBuilder {
    private Map<String, String> data; //key value pairs of computer components
    private Computer computer; //computer object to be built

    public CSVToComputerBuilderAdapter(Map<String, String> data) {
        this.data = data;
        this.computer = new Computer();
    }

    @Override
    public void Processor() {
        computer.setProcessor(new Processor(data.get("Processor"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public void Graphics() {
        computer.setGraphics(new GraphicsCard(data.get("Graphics"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public void Motherboard() {
        computer.setMotherboard(new Motherboard(data.get("Motherboard"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public void PowerSupply() {
        computer.setPowerSupply(new PowerSupply(data.get("PowerSupply"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public void Storage() {
        computer.setStorage(new Storage(data.get("Storage"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public void Memory() {
        computer.setMemory(new Memory(data.get("Memory"), "Unknown", "Unknown", 0.0));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
