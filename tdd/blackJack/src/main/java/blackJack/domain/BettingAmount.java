package blackJack.domain;

public class BettingAmount {
    private int amount;

    public BettingAmount(int amount) {
        this.amount = amount;
    }

    public int lose() {
        return amount *= -1;
    }

    public int blackJack() {
        return amount *= 1.5;
    }

    public void calculate(BettingAmount other) {
        this.amount += other.amount;
    }

    public int amount() {
        return amount;
    }

    public int win() {
        return amount;
    }
}
