package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (getCount() < this.capacity) {
            this.data.add(car);
        }
    }

    //•	Method buy(String manufacturer, String model)
    // – removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean buy(String manufacturer, String model) {
        for (Car c : data) {
            if (c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)) {
                this.data.remove(c);
                return true;
            }
        }
        return false;

    }

    //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar() {
        if (!data.isEmpty()){
            return data.stream().max(Comparator.comparingInt(car -> car.getYear())).get();
        }
        return null;
    }
    //•	Method getCar(String manufacturer, String model)
    // – returns the car with the given manufacturer and model or null if there is no such car.
        public Car getCar(String manufacturer, String model){
        if (!data.isEmpty()){
            return data.stream()
                    .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().get();
        }
        return null;
        }
    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(name).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();

    }
}
