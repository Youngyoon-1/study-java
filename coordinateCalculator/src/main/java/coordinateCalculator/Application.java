package coordinateCalculator;

import java.util.Scanner;

import coordinateCalculator.domain.CoordinateCalculator;
import coordinateCalculator.view.View;

public class Application {
    public static void main(String[] args) {
        CoordinateCalculator d = new CoordinateCalculator();
        d.setCoordinates("(10,10)-(14,15)");
        System.out.println(d.calcDistance());
    }
}
