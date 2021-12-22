package coordinateCalculator.view;

import static coordinateCalculator.domain.Value.*;

import java.util.List;

import coordinateCalculator.domain.Point;
import coordinateCalculator.dto.Result;

public class ResultView {
    public static final String SPACE_STRING = "    ";
    public static final String VERTICAL_MARK = "|";
    public static final String COORDINATE_MARK = ".";
    public static final String ORIGIN_MARK = "+";
    public static final String HORIZONTAL_MARK = "----";

    public static void printBoard(List<Point> points) {
        emptyLine();
        printVerticalLineWithCoordinates(points);
        printHorizontalLine();
    }

    private static void printVerticalLineWithCoordinates(List<Point> points) {
        for (int y = MAXIMUM_VALUE; y >= MINIMUM_VALUE; y--) {
            printVerticalNumber(y);
            System.out.print(VERTICAL_MARK);
            printCoordinate(y, points);
            emptyLine();
        }
    }

    private static void printHorizontalLine() {
        printHorizontalMark();
        printHorizontalNumber();
    }

    private static void printHorizontalNumber() {
        System.out.printf("%4d ", 0);
        for (int x = MINIMUM_VALUE; x <= MAXIMUM_VALUE; x++) {
            if (x % 2 == 0) {
                System.out.printf("%4d", x);
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

    private static void printCoordinate(int y, List<Point> points) {
        for (int x = MINIMUM_VALUE; x <= MAXIMUM_VALUE; x++) {
            printCoordinate(y, x, points);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void printCoordinate(int y, int x, List<Point> points) {
        if (isSameCoordinate(y, x, points)) {
            System.out.printf("%4s", COORDINATE_MARK);
            return;
        }
        System.out.print(SPACE_STRING);
    }

    private static boolean isSameCoordinate(int y, int x, List<Point> points) {
        return points.stream().anyMatch(point -> point.getY() == y && point.getX() == x);
    }

    private static void printVerticalNumber(int y) {
        if (y % 2 == 0) {
            System.out.printf("%4d", y);
            return;
        }
        System.out.print(SPACE_STRING);
    }

    public static void printResult(Result result) {
        emptyLine();
        System.out.println(result.toString());
    }
}
