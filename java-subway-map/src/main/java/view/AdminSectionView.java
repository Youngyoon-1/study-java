package view;

import java.util.Scanner;

public class AdminSectionView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String printMain() {
        System.out.println();
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String printMainDeleteSection() {
        System.out.println();
        System.out.println("## 삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String printPageDeleteByStationName() {
        System.out.println();
        System.out.println("## 삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine();
    }

    public static void printResultPageDeleteSection() {
        System.out.println();
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static String printMainAddSection() {
        System.out.println();
        System.out.println("## 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String printPageAddSectionByStationName() {
        System.out.println();
        System.out.println("## 역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String printPageAddSectionByOrder() {
        System.out.println();
        System.out.println("## 순서를 입력하세요.");
        return scanner.nextLine();
    }

    public static void printResultPageAddSection() {
        System.out.println();
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }
}
