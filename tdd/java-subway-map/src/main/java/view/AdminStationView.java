package view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Station;
import utils.ValidationUtil;

public class AdminStationView {
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
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public static String printPageAddStation() {
        try {
            System.out.println();
            System.out.println("## 등록할 역 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageAddStation();
        }
    }

    public static void printResultPageAddStation() {
        System.out.println();
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public static String printPageDeleteStation() {
        try {
            System.out.println();
            System.out.println("## 삭제할 역 이름을 입력하세요.");
            return ValidationUtil.checkStationLineName(scanner.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printPageDeleteStation();
        }
    }

    public static void printResultPageDeleteStation() {
        System.out.println();
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public static void printAllStation(List<Station> stations) {
        System.out.println();
        System.out.println("## 역 목록");
        stations.forEach(station -> System.out.println("[INFO] " + station.getName()));
    }
}
