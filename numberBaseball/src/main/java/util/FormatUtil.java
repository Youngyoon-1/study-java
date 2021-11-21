package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatUtil {
    public static List<Integer> convertList(int no){
        return Arrays.stream(Integer.toString(no).split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }
}
