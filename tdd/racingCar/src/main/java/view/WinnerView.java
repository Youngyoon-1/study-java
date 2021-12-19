package view;

import racingCar.domain.Cars;

public class WinnerView {
    public static final int INT = 2;
    public static final String STRING = ", ";

    public static void show(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        cars.getCars().forEach(car -> stringBuilder.append(car.getName() + " "));
        String winnerNames = stringBuilder.toString().trim().replace(" ", ", ");
        System.out.println("최종우승자 : " + winnerNames);
    }
}
