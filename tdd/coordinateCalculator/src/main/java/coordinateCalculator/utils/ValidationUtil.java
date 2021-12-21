package coordinateCalculator.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    static final String ERROR_PREFIX = "[ERROR] ";
    static final String ERROR_INVALID_FORM = "형식에 맞도록 입력해주세요.";
    static final String ERROR_DUPLICATION = "서로 다른 좌표값을 입력해주세요.";
    public static final String COORDINATE_DELIMITER = "-";

    public static void checkForm(String input) {
        String lineRegex = "\\([1-9]*[0-9],[1-9]*[0-9]\\)-\\([1-9]*[0-9],[1-9]*[0-9]\\)";
        String rectangleRegex = lineRegex + COORDINATE_DELIMITER + lineRegex;
        if (!Pattern.matches(lineRegex, input) && !Pattern.matches(rectangleRegex, input)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_INVALID_FORM);
        }
    }

    public static void checkDuplication(String input) {
        String[] values = input.split(COORDINATE_DELIMITER);
        if (values.length != Arrays.stream(values).distinct().count()) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_DUPLICATION);
        }
    }
}
