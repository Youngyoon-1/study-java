package view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import utils.ValidationUtil;

public class AdminLineView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String printMain() {
        try{
            printMainContent();
            return ValidationUtil.checkMainStationLinePage(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printMain();
        }
    }

    private static void printMainContent() {
        System.out.println();
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static String printPageAddLine() {
        try {
            System.out.println();
            System.out.println("## 등록할 노선 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageAddLine();
        }
    }

    public static String printPageAddAscendingStation() {
        try {
            System.out.println();
            System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageAddAscendingStation();
        }
    }

    public static String printPageDescendingStation() {
        try {
            System.out.println();
            System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageDescendingStation();
        }
    }

    public static void printResultPageAddLine() {
        System.out.println();
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static String printPageDeleteLine() {
        try {
            System.out.println();
            System.out.println("## 삭제할 노선 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageDeleteLine();
        }
    }

    public static void printResultPageDeleteLine() {
        System.out.println();
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void printAllLine(List<Line> lines) {
        System.out.println();
        System.out.println("## 노선 목록");
        lines.forEach(line -> System.out.println("[INFO] " + line.getName()));
    }
}
