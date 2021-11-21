package view;

import java.util.Scanner;

public class InputView {

    public static int input(Scanner sc){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextInt();
    }
    public static int choice(Scanner sc){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return sc.nextInt();
    }
}
