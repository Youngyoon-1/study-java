package stringAddCalc;

public class StringAddCalc {
    public static int calc(String inputStr){
        if (inputStr == "" || inputStr == null){
            return 0;
        }
        return Integer.parseInt(inputStr);
    }
}
