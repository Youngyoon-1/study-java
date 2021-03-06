package view;

import java.util.Scanner;

import utils.ValidationUtil;

public class IndexView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String print() {
        try{
            printMainContent();
            return ValidationUtil.checkIndexPage(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return print();
        }
    }

    private static void printMainContent() {
        System.out.println();
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }
}
