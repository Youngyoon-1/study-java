import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CalcUtil {

    private CalcUtil() throws InstantiationException { throw new InstantiationException("CalcUtil객체를 생성할 수 없습니다.");}

    public static List<String> removeOps(String regex, String s) {
        return Arrays.asList(s.split(regex));
    }

    public static List<String> removeNos(String s) {
        return Arrays.stream(s.split("[0-9]"))
                .filter(op->!op.equals(""))
                .collect(Collectors.toList());
    }

    public static String input(Scanner sc){
        System.out.println("다음줄에 값을 입력하세요.");
        return sc.nextLine();
    }

    public static void output(int result){
        System.out.println("결과값: " + result);
    }
}
