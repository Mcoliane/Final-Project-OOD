package groupproject;

// GraphicsCard class 
//assuming name will be the name of the graphics card
//assume manufacturer is amd or nvidia
public class GraphicsCard {
    private String name;
    private String model;
    private String manufacturer;
    private double cost;

    public GraphicsCard(String name, String model, String manufacturer, double cost) {
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

    public double getCost() {
        return cost;
    }
}