package fuelInjection.domain;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static final String NEWLINE = System.getProperty("line.separator");

    private List<Car> cars = new ArrayList<>();

    public static Company create() {
        return new Company();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        cars.stream().forEach(car -> sb.append(car.report() + NEWLINE));
        return sb.toString();
    }
}
