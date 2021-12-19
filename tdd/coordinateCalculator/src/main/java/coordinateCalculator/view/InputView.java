package coordinateCalculator.view;

import java.util.Scanner;

import coordinateCalculator.utils.ValidationUtil;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String SPACE_STRING = " ";
    public static final String EMPTY_STRING = "";
    public static final String MESSAGE_GET_COORDINATES = "좌표를 입력하세요.";

    public static String getCoordinates() {
        emptyLine();
        System.out.println(MESSAGE_GET_COORDINATES);
        String userInput = readLine();
        if (isValid(userInput)) {
            return userInput;
        }
        return getCoordinates();
    }

    private static boolean isValid(String input) {
        try {
            ValidationUtil.checkForm(input);
            ValidationUtil.checkDuplication(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static String readLine() {
        return scanner.nextLine().replace(SPACE_STRING, EMPTY_STRING);
    }

    private static void emptyLine() {
        System.out.println();
    }
}
