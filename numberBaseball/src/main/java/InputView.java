import java.util.Scanner;

public class InputView {
    static String receiveNos(Scanner sc){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }
}
