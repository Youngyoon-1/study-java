package view;

import java.util.Scanner;

import racingCar.domain.Token;

public class CountInputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Token show() {
        System.out.println("횟수를 입력해주세요!@!@");
        try {
            return new Token(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return show();
        }

    }
}
