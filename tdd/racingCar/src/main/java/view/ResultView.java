package view;

import java.util.stream.IntStream;

import racingCar.domain.Car;
import racingCar.domain.Result;

public class ResultView {
    public static void show(Result result) {
        System.out.println("경기결과");
        result.getResult().forEach(cars -> {
            cars.getCars().forEach(car -> System.out.println(car.getName() + " : " + convertPosition(car)));
            System.out.println();
            }
        );
    }

    private static StringBuilder convertPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(1, car.getPosition().get()).forEach(i -> stringBuilder.append("-"));
        return stringBuilder;
    }
}
