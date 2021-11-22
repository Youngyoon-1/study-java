import racingCar.Cars;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cars cars = new Cars(InputView.inputName(sc));
        OutputView.printReport(cars.play(InputView.inputCount(sc)));
        OutputView.printWinner(cars.getWinnerName());
    }
}
