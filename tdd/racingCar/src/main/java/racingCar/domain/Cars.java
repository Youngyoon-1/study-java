package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void moveCars(Fuel fuel) {
        cars.stream().forEach(car -> car.move(fuel));
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars deepClone() {
        Cars newCars = new Cars();
        cars.stream().forEach(car -> newCars.add(car.deepClone()));
        return newCars;
    }
}
