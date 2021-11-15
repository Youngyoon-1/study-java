public class Operator implements Calculable{

    String symbol;

    public Operator(String symbol){
        this.symbol = symbol;
    }

    @Override
    public int calc(int a, int b) {
        return 0;
    }
}
