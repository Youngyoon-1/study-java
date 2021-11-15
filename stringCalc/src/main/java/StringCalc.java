public class StringCalc {
    static private final StringCalc stringCalc = new StringCalc();

    private StringCalc(){}

    static StringCalc getInstance(){
        return stringCalc;
    }
    public int calc(String str){
        str = str.replaceAll(" ","");   //공백제거
        return 0;
    }

}
