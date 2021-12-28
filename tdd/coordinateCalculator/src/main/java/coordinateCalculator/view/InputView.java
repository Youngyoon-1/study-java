package coordinateCalculator.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import coordinateCalculator.domain.Figure;
import coordinateCalculator.domain.FigureFactory;
import coordinateCalculator.domain.Point;
import coordinateCalculator.domain.Points;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Figure input() {
        emptyLine();
        System.out.println("좌표를 입력하세요.");
        String input = readLine();
        Points points = generatePoints(input);
        return FigureFactory.create(points);
    }

    static Points generatePoints(String input) {
        List<Point> points = new ArrayList<>();
        String[] inputString = input.replaceAll("[()]", "").split("-");
        for (String s : inputString) {
            int[] coordinates = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            points.add(Point.of(coordinates[0], coordinates[1]));
        }
        return new Points(points);
    }

    private static String readLine() {
        return scanner.nextLine().replace(" ", "");
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void checkValidation(String s) {
    }
}
