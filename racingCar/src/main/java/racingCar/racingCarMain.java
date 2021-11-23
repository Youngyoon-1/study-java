package racingCar;

import racingCar.domain.Cars;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class racingCarMain {
    public static void main(String[] args) {
        Cars cars = new Cars(InputView.inputName());
        OutputView.printReport(cars.play(InputView.inputCount()));
        OutputView.printWinner(cars.getWinnerName());
    }
}
