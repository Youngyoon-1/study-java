package coordinateCalculator;

import java.util.Scanner;

import coordinateCalculator.domain.CoordinateCalculator;
import coordinateCalculator.view.View;

public class Adapter {
    private final CoordinateCalculator coordinateCalculator = new CoordinateCalculator();

    public void run(Scanner scanner) {
        String request = View.inputCoordinate(scanner);
        setCoordinates(scanner, request);
        coordinateCalculator.calcDistance();
    }

    private void setCoordinates(Scanner scanner, String request) {
        try {
            coordinateCalculator.setCoordinates(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run(scanner);
        }
    }
}
