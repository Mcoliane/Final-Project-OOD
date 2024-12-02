package groupproject;

public class Motherboard {
    private String name;
    private String model;
    private String manufacturer;

    public Motherboard(String name, String model, String manufacturer) {
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
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
}