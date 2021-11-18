package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatUtil {

    private FormatUtil() throws InstantiationException {
        throw new InstantiationException("FormatUtil은 객체화 할 수 없습니다.");
    }

    public static List<Integer> convertStr(String s) {
        return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }


}
