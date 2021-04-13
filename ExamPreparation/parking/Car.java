package parking;

public class Car {
    //•	manufacturer: String
    //•	model: String
    //•	year: int
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return this.manufacturer + " " + this.model + " (" + this.year + ")";
    }
}
