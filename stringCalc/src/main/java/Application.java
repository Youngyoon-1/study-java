import util.CalcUtil;

import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        CalcUtil.output(StringCalc.getInstance().calc(CalcUtil.input(sc)));
    }
}
