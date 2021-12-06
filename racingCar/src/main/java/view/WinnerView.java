package view;

import racingCar.domain.Cars;

public class WinnerView {
    public static final int INT = 2;
    public static final String STRING = ", ";

    public static void show(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        cars.getStream().forEach(car -> stringBuilder.append(car.getName() + STRING));
        stringBuilder.delete(stringBuilder.length() - INT, stringBuilder.length()-1);
        System.out.println("최종우승자 : " + stringBuilder);
    }
}
