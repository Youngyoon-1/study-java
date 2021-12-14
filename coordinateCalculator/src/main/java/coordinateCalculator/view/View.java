package coordinateCalculator.view;

import java.util.Scanner;
import java.util.stream.IntStream;

import coordinateCalculator.domain.Coordinate;
import coordinateCalculator.domain.Coordinates;

public class View {
    public static String inputCoordinate(Scanner scanner) {
        System.out.println("좌표를 입력하세요.");
        return scanner.nextLine().replace(" ", "");
    }
    
    public static void printCoordinates(Coordinates coordinates) {
        int maxNumber = 24;
        for (int y = 0; y <= maxNumber; y++) {
            if (y % 2 == 0 && y != maxNumber) {
                System.out.printf("%2d|", maxNumber - y);
            }
            if (y % 2 != 0) {
                System.out.print("  |");
            }
            if (y == maxNumber) {
                System.out.print("  +");
                IntStream.range(0, maxNumber).forEach(i -> {
                    System.out.print("-");
                    if (i != maxNumber - 1) {
                        System.out.print("-");
                    }
                });
            }
            for (int x = 0; x <= maxNumber; x++) {
                for (Coordinate coordinate : coordinates.get()) {
                    if (coordinate.isSame(x, maxNumber - y)) {
                        for (int i = 0; i < x; i++) {
                            System.out.print(" ");
                        }
                        System.out.print("﹒");
                    }
                }
            }
            System.out.println();
        }
        IntStream.rangeClosed(0, maxNumber).forEach(i -> {
            if (i % 2 == 0) {
                System.out.printf("%2d", i);
            }
            if (i % 2 != 0) {
                System.out.print("  ");
            }
        });
        System.out.println();
    }

    public static void printResult(double distance) {

    }
}
