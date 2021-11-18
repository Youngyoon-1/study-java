import java.util.Scanner;

public class InputView {
    static String receiveNos(Scanner sc){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    static String receiveNo(Scanner sc){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextLine();
    }
}
