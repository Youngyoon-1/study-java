package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidationUtil {

    private ValidationUtil() throws InstantiationException { throw new InstantiationException("ValidationUtil객체는 생성할 수 없습니다.");}

    public static void checkFirstIdx(String s) {
        if(!(s.charAt(0) >= '0' && s.charAt(0) <='9'))
            throw new IllegalArgumentException("첫입력자는 숫자여야합니다.");
    }

    public static void checkLastIdx(String s) {
        int lastIdx = s.length() - 1;
        if(!(s.charAt(lastIdx) >= '0' && s.charAt(lastIdx) <= '9'))
            throw new IllegalArgumentException("마지막 입력자는 숫자여야합니다.");
    }

    public static void checkOp(String regex, String s) {
        s = s.replaceAll("[0-9]","");
        s = s.replaceAll(regex,"");
        if(!s.equals(""))
            throw new IllegalArgumentException("연산자가 올바르지 않습니다.");
    }


    public static void checkDuplicatedOp(String s) {
        String[] ops = s.split("[0-9]");
        if(Arrays.stream(ops).anyMatch(op -> op.length() > 1))
            throw new IllegalArgumentException("연산자 다음에는 숫자를 입력해주세요.");

    }
}
