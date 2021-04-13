package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }
    //•	Getter getCount() – returns the number of cars.
    public int getCount(){
        return data.size();
    }
    //•	Method add(Car car) – adds an entity to the data if there is an empty cell for the car.
    public void add(Car car){
        if (this.data.size() < this.capacity){
            this.data.add(car);
        }
    }
    //•	Method remove(String manufacturer, String model)
    // – removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model){
        return data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
        }
        //•	Method getLatestCar() – returns the latest car (by year) or null if have no cars.
    public Car getLatestCar(){
        if (!data.isEmpty()){
            return data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
        return null;
    }
    //•	Method getCar(String manufacturer, String model)
    // – returns the car with the given manufacturer and model or null if there is no such car.
        public Car getCar(String manufacturer, String model){
        if (!data.isEmpty()){
            return data
                    .stream()
                    .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)).findFirst().get();
        }
        return null;
        }
    //•	getStatistics() – returns a String in the following format:
    //"The cars are parked in {parking type}:
    //{Car1}

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            sb.append(car).append(System.lineSeparator());
        }

        return String.valueOf(sb);
    }

    }


