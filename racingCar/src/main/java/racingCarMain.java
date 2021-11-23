import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class racingCarMain {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputName());
        OutputView.printReport(cars.play(InputView.inputCount()));
        OutputView.printWinner(cars.getWinnerName());
    }
}
