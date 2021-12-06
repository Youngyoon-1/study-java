package view;

import java.util.Scanner;

import racingCar.domain.Names;

public class NamesInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Names show() {
        System.out.println("이름을 입력해주세요~!~@!@");

        try {
            return new Names(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return show();
        }

    }
}
