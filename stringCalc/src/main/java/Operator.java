import java.util.Arrays;

public enum Operator{
    PLUS("+",(a,b)->a+b),
    MINUS("-",(a,b)->a-b),
    MULTIPLY("*",(a,b)->a*b),
    DIVIDE("/",(a,b)->a/b);

    String symbol;
    Calculable op;

    Operator(String symbol, Calculable op){
        this.symbol = symbol;
        this.op = op;
    }

    public static Operator of(String symbol){
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .get();
    }

    @FunctionalInterface
    interface Calculable{
        public int calc(int a, int b);
    }

}
