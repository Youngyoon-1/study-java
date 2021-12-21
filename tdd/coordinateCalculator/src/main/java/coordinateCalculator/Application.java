package coordinateCalculator;

import coordinateCalculator.controller.Controller;
import coordinateCalculator.domain.Line;
import coordinateCalculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        new Controller().run();
    }
}
