package coordinateCalculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static void checkForm(String input) {
        String regex = "\\([1-9]*[0-9],[1-9]*[0-9]\\)-\\([1-9]*[0-9],[1-9]*[0-9]\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 형식에 맞도록 입력해주세요.");
        }
        // if (Pattern.matches(regex, input)) {
        //     throw new IllegalArgumentException("[ERROR] 형식에 맞도록 입력해주세요.");
        // }
    }
}
