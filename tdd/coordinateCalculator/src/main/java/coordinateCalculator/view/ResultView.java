package coordinateCalculator.view;

import static coordinateCalculator.domain.Point.*;

import coordinateCalculator.domain.Figure;
import coordinateCalculator.domain.Point;

public class ResultView {
    public static final String Y_AXIS_STRING = "|";
    public static final String COORDINATE_STRING = ".";
    public static final String ONE_SPACE_STRING = "    ";
    public static final String ORIGIN_STRING = "+";
    public static final String X_AXIS_STRING = "----";

    public static void showPlane(Figure figure) {
        emptyLine();
        printYAxis(figure);
        printXAxis();
    }

    private static void printYAxis(Figure figure) {
        for (int y = COORDINATE_MAXIMUM_NUMBER; y >= COORDINATE_MINIMUM_NUMBER; y--) {
            printAxisNumber(y);
            System.out.print(Y_AXIS_STRING);
            printCoordinate(y, figure);
            emptyLine();
        }
    }

    private static void printCoordinate(int y, Figure figure) {
        for (int x = COORDINATE_MINIMUM_NUMBER; x <= COORDINATE_MAXIMUM_NUMBER; x++) {
            printCoordinate(x, y, figure);
        }
    }

    private static void printCoordinate(int x, int y, Figure figure) {
        if (figure.points().hasPoint(Point.of(x, y))) {
            System.out.printf("%4s", COORDINATE_STRING);
            return;
        }
        System.out.print(ONE_SPACE_STRING);
    }

    private static void printAxisNumber(int i) {
        if (i % 2 == 0) {
            System.out.printf("%4d", i);
            return;
        }
        System.out.print(ONE_SPACE_STRING);
    }

    private static void printXAxis() {
        System.out.print(ONE_SPACE_STRING +  ORIGIN_STRING);
        for (int x = COORDINATE_MINIMUM_NUMBER; x <= COORDINATE_MAXIMUM_NUMBER; x++) {
            System.out.print(X_AXIS_STRING);
        }
        emptyLine();
        printXAxisNumber();
    }

    private static void printXAxisNumber() {
        System.out.printf("%4d ", 0);
        for (int x = COORDINATE_MINIMUM_NUMBER; x <= COORDINATE_MAXIMUM_NUMBER; x++) {
            printAxisNumber(x);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }
}
