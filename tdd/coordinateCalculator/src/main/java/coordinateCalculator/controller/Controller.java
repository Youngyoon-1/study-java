package coordinateCalculator.controller;

import coordinateCalculator.domain.Figure;
import coordinateCalculator.domain.FigureFactory;
import coordinateCalculator.view.InputView;
import coordinateCalculator.view.ResultView;

public class Controller {
    public void run() {
        String request = InputView.getCoordinates();
        if (isValidRequest(request)) {
            Figure figure = FigureFactory.from(request);
            ResultView.printBoard(figure.coordinates());
            ResultView.printResult(figure.getResult());
            return;
        }
        run();
    }

    private boolean isValidRequest(String request) {
        try {
            FigureFactory.from(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
