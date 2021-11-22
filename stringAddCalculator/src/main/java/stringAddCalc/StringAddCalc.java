package stringAddCalc;

import java.util.Arrays;

public class StringAddCalc {
    public static int calc(String inputStr){
        if (inputStr == "" || inputStr == null){
            return 0;
        }
        return Arrays.stream(inputStr.split(",|:")).mapToInt(Integer::parseInt).sum();
    }
}
