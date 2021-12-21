package coordinateCalculator.controller;

import coordinateCalculator.domain.Line;
import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class Controller {
    public void run() {
        String request = InputView.getCoordinates();
        if (isValidRequest(request)) {
            Line line = new Line(request);
            ResultView.printBoard(line.getCoordinates());
            ResultView.printResult(line.length());
            return;
        }
        run();
    }

    private boolean isValidRequest(String request) {
        try {
            new Line(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
