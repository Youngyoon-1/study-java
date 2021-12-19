package racingCar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingCar.domain.Names;
import racingCar.domain.RandomFuel;
import racingCar.repository.CarRepository;

public class CarServiceTest {

    @Test
    void makeCars() {
        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository,new RandomFuel());
        Names names = new Names("1,2,3");
        carService.makeCars(names);
    }
}
