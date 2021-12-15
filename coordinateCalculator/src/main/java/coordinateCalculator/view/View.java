package coordinateCalculator.view;

import java.util.Scanner;

import coordinateCalculator.domain.Coordinate;
import coordinateCalculator.domain.Coordinates;

public class View {
    public static String inputCoordinate(Scanner scanner) {
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine().replace(" ", "");
    }

    public static void showResult(Coordinates coordinates) {
        printEmptyLine();
        showVerticalNumbersWith(coordinates);
        printHorizontalAxis();
        printHorizontalNumber();
    }

    private static void showVerticalNumbersWith(Coordinates coordinates) {
        for (int y = Coordinate.MAXIMUM_NUMBER; y >= 1; y--) {
            printAxisNumber(y);
            printVerticalAxis();
            printPoint(coordinates, y);
            printEmptyLine();
        }
    }

    private static void printHorizontalNumber() {
        System.out.print("   0 ");
        for (int x = 1; x <= Coordinate.MAXIMUM_NUMBER; x++) {
            printAxisNumber(x);
        }
        printEmptyLine();
    }

    private static void printHorizontalAxis() {
        System.out.print(String.format("%5s", "+"));
        for (int x = 1; x <= Coordinate.MAXIMUM_NUMBER; x++) {
            System.out.print("----");
        }
        printEmptyLine();
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    private static void printPoint(Coordinates coordinates, int y) {
        for (int x = 1; x <= Coordinate.MAXIMUM_NUMBER; x++) {
            if (coordinates.hasPoint(x, y)) {
                System.out.print(String.format("%4s", "."));
                continue;
            }
            System.out.print("    ");
        }
    }

    private static void printVerticalAxis() {
        System.out.print("|");
    }

    private static void printAxisNumber(int index) {
        if (index % 2 == 0) {
            System.out.print(String.format("%4d", index));
            return;
        }
        System.out.print("    ");
    }

    public static void printDistance(double distance) {
        System.out.println();
        System.out.println("두 점 사이의 거리는 " + distance);
    }
}
