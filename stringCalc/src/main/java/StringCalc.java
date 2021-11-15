public class StringCalc {
    private static final StringCalc stringCalc = new StringCalc();

    private StringCalc(){}

    public static StringCalc getInstance(){
        return stringCalc;
    }

    public int calc(String str){
        str = str.replaceAll(" ","");   //공백제거
        return 0;
    }

}
