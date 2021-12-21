package coordinateCalculator.view;

import static coordinateCalculator.domain.Value.*;

import java.util.List;

import coordinateCalculator.domain.Coordinate;

public class ResultView {
    public static final int MINIMUM_VALUE = 1;
    public static final String SPACE_STRING = "    ";
    public static final String VERTICAL_MARK = "|";
    public static final String COORDINATE_MARK = ".";
    public static final String ORIGIN_MARK = "+";
    public static final String HORIZONTAL_MARK = "----";

    public static void printBoard(List<Coordinate> coordinates) {
        emptyLine();
        printVerticalLineWithCoordinates(coordinates);
        printHorizontalLine();
    }

    private static void printVerticalLineWithCoordinates(List<Coordinate> coordinates) {
        for (int i = MAXIMUM_VALUE; i >= MINIMUM_VALUE; i--) {
            printVerticalNumber(i);
            System.out.print(VERTICAL_MARK);
            printCoordinate(i, coordinates);
            emptyLine();
        }
    }

    private static void printHorizontalLine() {
        printHorizontalMark();
        printHorizontalNumber();
    }

    private static void printHorizontalNumber() {
        System.out.printf("%4d ", 0);
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            if (i % 2 == 0) {
                System.out.printf("%4d", i);
                continue;
            }
            System.out.print(SPACE_STRING);
        }
    }

    private static void printHorizontalMark() {
        System.out.print(SPACE_STRING + ORIGIN_MARK);
        for (int i = MINIMUM_VALUE; i <= MAXIMUM_VALUE; i++) {
            System.out.print(HORIZONTAL_MARK);
        }
        emptyLine();
    }

    private static void printCoordinate(int i, List<Coordinate> coordinates) {
        for (int j = MINIMUM_VALUE; j <= MAXIMUM_VALUE; j++) {
            printCoordinate(i, j, coordinates);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void printCoordinate(int i, int j, List<Coordinate> coordinates) {
        if (isSameCoordinate(i, j, coordinates)) {
            System.out.printf("%4s", COORDINATE_MARK);
            return;
        }
        System.out.print(SPACE_STRING);
    }

    private static boolean isSameCoordinate(int i, int j, List<Coordinate> coordinates) {
        return coordinates.stream().anyMatch(coordinate -> {
            if (coordinate.getY() == i && coordinate.getX() == j) {
                return true;
            }
            return false;
        });
    }

    private static void printVerticalNumber(int i) {
        if (i % 2 == 0) {
            System.out.printf("%4d", i);
            return;
        }
        System.out.print(SPACE_STRING);
    }
}
