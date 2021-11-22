package stringAddCalc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVal {

    public static final String EMPTY = "";
    public static final String REGEX = ",|:";
    public static final String ZERO_STRING = "0";

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public static final int FIRST = 1;
    public static final int SECOND = 2;

    private final String value;

    public static InputVal makeInstance(String value){
        if(checkNull(value) || checkEmpty(value)){
            return new InputVal(ZERO_STRING);
        }
        return new InputVal(value);
    }

    private InputVal(String value){
        this.value = value;
    }

    private static boolean checkEmpty(String value) {
        return EMPTY.equals(value);
    }

    private static boolean checkNull(String value) {
        return value == null;
    }

    private boolean checkMinus(int no) {
        if(no < 0){
            throw new RuntimeException();

        }
        return true;
    }

    public int calc(){
        Matcher matcher = pattern.matcher(value);
        if(matcher.find()){
            String customDelimiter =  matcher.group(FIRST);
            return Arrays.stream(matcher.group(SECOND).split(customDelimiter)).mapToInt(Integer::parseInt)
                    .filter(no -> checkMinus(no)).sum();
        }
        return Arrays.stream(value.split(REGEX)).mapToInt(Integer::parseInt)
                .filter(no -> checkMinus(no)).sum();
    }

}
