package coordinateCalculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new Adapter().run(new Scanner(System.in));
    }
}
