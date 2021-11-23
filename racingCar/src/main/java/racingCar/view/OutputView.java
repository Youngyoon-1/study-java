package racingCar.view;

public class OutputView {
    public static final String SEPARATE = ",";
    public static final String SPACE = " ";

    public static void printReport(String report){
        System.out.println("\n실행 결과");
        System.out.print(report);
    }

    public static void printWinner(String winner){
        winner = winner.replaceAll(SEPARATE, SEPARATE + SPACE);
        System.out.println(winner + "가 최종 우승했습니다.");
    }

}
