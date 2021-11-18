package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatUtil {
    public static List<Integer> convertStr(String s) {
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
