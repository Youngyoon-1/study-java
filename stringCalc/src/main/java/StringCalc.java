import java.util.List;

public class StringCalc {
    private static final StringCalc stringCalc = new StringCalc();

    private StringCalc(){}

    public static StringCalc getInstance(){
        return stringCalc;
    }

    public int calc(String str){
        int result = 0;
        str = str.replaceAll(" ","");   //공백제거
        ValidationUtil.checkFirstIdx(str);
        ValidationUtil.checkLastIdx(str);
        ValidationUtil.checkOp("[\\+|\\*|/|-]",str);
        List<String> nos = CalcUtil.removeOp("[\\+|\\*|/|-]",str);
        List<String> ops = CalcUtil.removeNos(str);
        result = Integer.parseInt(nos.get(0));
        for(int i = 1; i < nos.size(); i++){
            result = Operator.of(ops.get(i-1)).op.calc(result,Integer.parseInt(nos.get(i)));
        }
        return result;
    }

}
