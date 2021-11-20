package view;

import java.util.Scanner;

public class InputView {
    public static int print(Scanner sc){
        System.out.print("숫자를 입력해 주세요 : ");
        return sc.nextInt();
    }
}
