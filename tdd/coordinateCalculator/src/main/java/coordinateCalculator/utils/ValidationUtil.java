package coordinateCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    static final String ERROR_PREFIX = "[ERROR] ";
    static final String ERROR_INVALID_FORM = "형식에 맞도록 입력해주세요.";
    static final String ERROR_DUPLICATION = "서로 다른 좌표값을 입력해주세요.";
    public static final String COORDINATE_DELIMITER = "-";
    public static final int FIRST_INPUT_INDEX = 0;
    public static final int SECOND_INPUT_INDEX = 1;

    public static void checkForm(String input) {
        String regex = "\\([1-9]*[0-9],[1-9]*[0-9]\\)-\\([1-9]*[0-9],[1-9]*[0-9]\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_FORM);
        }
    }

    public static void checkDuplication(String input) {
        String[] values = input.split(COORDINATE_DELIMITER);
        if (values[FIRST_INPUT_INDEX].equals(values[SECOND_INPUT_INDEX])) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_DUPLICATION);
        }
    }
}
