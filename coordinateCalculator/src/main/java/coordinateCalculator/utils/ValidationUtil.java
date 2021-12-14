package coordinateCalculator.utils;

import java.util.regex.Pattern;

public class ValidationUtil {
    public static final String PATTERN_COORDINATES = "\\([0-9]+,[0-9]+\\)-\\([0-9]+,[0-9]+\\)";

    public static void checkCoordinates(String coordinate) {
        if (!Pattern.matches(PATTERN_COORDINATES, coordinate)) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 다시 입력해주세요.");
        }
    }
}
