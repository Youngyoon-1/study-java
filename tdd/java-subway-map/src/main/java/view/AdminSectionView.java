package view;

import java.util.Scanner;

import utils.ValidationUtil;

public class AdminSectionView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String printMain() {
        try {
            printMainContent();
            return ValidationUtil.checkMainSectionPage(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printMain();
        }
    }

    private static void printMainContent() {
        System.out.println();
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static String printMainDeleteSection() {
        try {
            System.out.println();
            System.out.println("## 삭제할 구간의 노선을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printMainDeleteSection();
        }
    }

    public static String printPageDeleteByStationName() {
        try {
            System.out.println();
            System.out.println("## 삭제할 구간의 역을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageDeleteByStationName();
        }
    }

    public static void printResultPageDeleteSection() {
        System.out.println();
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    public static String printMainAddSection() {
        try {
            System.out.println();
            System.out.println("## 노선을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printMainAddSection();
        }
    }

    public static String printPageAddSectionByStationName() {
        try {
            System.out.println();
            System.out.println("## 역이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageAddSectionByStationName();
        }
    }

    public static String printPageAddSectionByOrder() {
        try {
            System.out.println();
            System.out.println("## 순서를 입력하세요.");
            return ValidationUtil.checkNumber(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageAddSectionByOrder();
        }
    }

    public static void printResultPageAddSection() {
        System.out.println();
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }
}
