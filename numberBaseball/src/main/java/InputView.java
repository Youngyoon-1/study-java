import java.util.Scanner;

public class InputView {

    private InputView() throws InstantiationException {
        throw new InstantiationException("InputView클래스는 객체화 할 수 없습니다.");
    }

    static String receiveNos(Scanner sc){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextLine();
    }

    static String receiveNo(Scanner sc){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextLine();
    }
}
