package racingCar.service;

import java.util.stream.IntStream;

import racingCar.domain.Car;
import racingCar.domain.Cars;
import racingCar.domain.Fuel;
import racingCar.domain.Names;
import racingCar.domain.Position;
import racingCar.domain.Result;
import racingCar.domain.Token;
import racingCar.repository.CarRepository;

public class CarService {
    public static final int START_INCLUSIVE = 0;

    private final CarRepository carRepository;
    private final Fuel fuel;

    public CarService(CarRepository carRepository, Fuel fuel) {
        this.carRepository = carRepository;
        this.fuel = fuel;
    }

    public void makeCars(Names names) {
        names.getStream().map(Car::new).forEach(carRepository::add);
    }

    public Result play(Token token) {
        Result result = new Result();
        IntStream.range(START_INCLUSIVE, token.getToken()).forEach(i -> {
                moveCars();
                result.add(getCars());
            }
        );
        return result;
    }

    public Cars getWinner() {
        return carRepository.findCarByPosition(findMaxPosition());
    }

    private Position findMaxPosition() {
        return carRepository.findMaxPosition();
    }

    private void moveCars() {
        carRepository.moveCars(fuel);
    }

    private Cars getCars() {
        return carRepository.getCars();
    }
}
