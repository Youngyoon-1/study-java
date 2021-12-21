package coordinateCalculator.utils;

import static coordinateCalculator.domain.FigureFactory.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidationUtil {
    static final String ERROR_PREFIX = "[ERROR] ";
    static final String ERROR_INVALID_FORM = "형식에 맞도록 입력해주세요.";
    static final String ERROR_DUPLICATION = "서로 다른 좌표값을 입력해주세요.";
    public static final String COORDINATE_TEMPLATE = "\\([1-9]*[0-9],[1-9]*[0-9]\\)";

    public static void checkForm(String input) {
        String lineRegex = COORDINATE_TEMPLATE + COORDINATE_DELIMITER + COORDINATE_TEMPLATE;
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
