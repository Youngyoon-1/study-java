package coordinateCalculator.controller;

import coordinateCalculator.domain.Line;
import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class Controller {
    public void run() {
        String request = InputView.getCoordinates();
        Line line = new Line(request);
        ResultView.printBoard(line.getCoordinates());
    }
}
