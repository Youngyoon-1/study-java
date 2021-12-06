package view;

import java.util.stream.IntStream;

import racingCar.domain.Result;

public class ResultView {
    public static void show(Result result) {
        System.out.println("경기결과");
        result.getStream().forEach(cars -> cars.getStream().forEach(car -> {
            StringBuilder stringBuilder = new StringBuilder();
            IntStream.range(1 ,car.getPosition().get()).forEach(i -> stringBuilder.append("-"));
            System.out.println(car.getName() + " : " + car.getPosition());
        }));
    }
}
