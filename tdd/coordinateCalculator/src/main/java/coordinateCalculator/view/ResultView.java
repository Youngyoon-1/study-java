package coordinateCalculator.view;

import static coordinateCalculator.domain.Value.*;

import java.util.List;

import coordinateCalculator.domain.Point;

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
        for (int i = MAXIMUM_VALUE; i >= MINIMUM_VALUE; i--) {
            printVerticalNumber(i);
            System.out.print(VERTICAL_MARK);
            printCoordinate(i, points);
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

    private static void printCoordinate(int i, List<Point> points) {
        for (int j = MINIMUM_VALUE; j <= MAXIMUM_VALUE; j++) {
            printCoordinate(i, j, points);
        }
    }

    private static void emptyLine() {
        System.out.println();
    }

    private static void printCoordinate(int i, int j, List<Point> points) {
        if (isSameCoordinate(i, j, points)) {
            System.out.printf("%4s", COORDINATE_MARK);
            return;
        }
        System.out.print(SPACE_STRING);
    }

    private static boolean isSameCoordinate(int i, int j, List<Point> points) {
        return points.stream().anyMatch(point -> {
            if (point.getY() == i && point.getX() == j) {
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

    public static void printResult(double length) {
        emptyLine();
        System.out.println("두 점 사이 거리는 " + length);
    }
}
