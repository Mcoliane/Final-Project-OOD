package groupproject;

// GraphicsCard class 
//assuming name will the be the name of the graphics card
//assume manufacturer is amd or nvidia
public class GraphicsCard {
    private String name;
    private String model;
    private String manufacturer;

    public GraphicsCard(String name, String model, String manufacturer) {
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