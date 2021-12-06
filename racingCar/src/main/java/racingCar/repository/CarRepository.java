package racingCar.repository;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.Fuel;
import racingCar.domain.Position;

public class CarRepository {
    private final Cars cars;

    public CarRepository() {
        this.cars = new Cars();
    }

    public void add(Car car) {
        cars.add(car);
    }

    public void moveCars(Fuel fuel) {
        cars.moveCars(fuel);
    }

    public Cars getCars() {
        return cars.deepClone();
    }

    public Position findMaxPosition() {
        return cars.getStream().max(Car::compareTo).get().getPosition();
    }

    public Cars findCarByPosition(Position position) {
        Cars winner = new Cars();
        cars.getStream().filter(car -> car.isSamePosition(position)).forEach(winner::add);
        return winner;
    }
}


