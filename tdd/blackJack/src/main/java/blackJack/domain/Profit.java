package blackJack.domain;

public class Profit {
    private int profit = 0;

    @Override
    public String toString() {
        return Integer.toString(profit);
    }

    public void add(int profit) {
        this.profit += profit;
    }

    public int get() {
        return profit;
    }
}
