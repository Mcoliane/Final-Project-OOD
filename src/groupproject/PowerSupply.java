package groupproject;

public class PowerSupply {
    private String name;
    private String model;
    private String manufacturer;
    private double cost;

    public PowerSupply(String name, String model, String manufacturer, double cost) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }
}