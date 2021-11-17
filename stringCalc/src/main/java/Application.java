import util.CalcUtil;
import util.ValidationUtil;

import java.util.Scanner;

public class Application {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        init();
    }
    private static void init() {
        String str = CalcUtil.removeSpace(CalcUtil.input(sc));
        try{
            ValidationUtil.checkFirstIdx(str);
            ValidationUtil.checkLastIdx(str);
            ValidationUtil.checkOp("[\\+|\\*|/|-]",str);
            ValidationUtil.checkDuplicatedOp(str);
            ValidationUtil.checkDivideByZero(str);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            init();
            return;
        }
        CalcUtil.output(StringCalc.getInstance().calc(str));
    }
}
