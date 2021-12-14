package coordinateCalculator.view;

import java.util.Scanner;
import java.util.stream.IntStream;

public class View {
    public static String mainPage(Scanner scanner) {
        int maxNumber = 24;
        printY(maxNumber);
        printX(maxNumber);
        return scanner.nextLine().replace(" ", "");
    }

    private static void printX(int maxNumber) {
        System.out.print("  +");
        IntStream.range(0, maxNumber).forEach(i -> System.out.print("--"));
        System.out.println();
        for (int i = 0; i <= maxNumber; i++) {
            if (i % 2 == 0) {
                System.out.printf("%2d", i);
            }
            if (i % 2 != 0) {
                System.out.print("  ");
            }
        }
    }

    private static void printY(int maxNumber) {
        while (maxNumber != 1) {
            if (maxNumber % 2 == 0) {
                System.out.printf("%2d|%n", maxNumber);
            }
            if (maxNumber % 2 == 0) {
                System.out.println("  |");
            }
            maxNumber--;
        }
    }
}