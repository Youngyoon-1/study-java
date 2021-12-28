package coordinateCalculator.controller;

import coordinateCalculator.domain.Figure;
import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class CoordinateCalculatorController {
    public void run() {
        Figure figure = InputView.input();
        ResultView.showPlane(figure);
    }
}
