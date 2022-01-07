package blackJack.domain;

import java.util.Objects;

public class Player extends AbstractParticipant {
    private final PlayerName name;
    private BettingAmount bettingAmount;

    public Player(PlayerName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setBettingAmount(BettingAmount bettingAmount) {
        this.bettingAmount = bettingAmount;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public String showCard() {
        return this + "카드: " + String.join(", ", cards.showCard());
    }

    public boolean canPickCard() {
        return state.isRunning();
    }

    public void stay() {
        state = State.STAY;
    }

    public void calculateProfit(Dealer dealer) {
        state.calculateProfit(this, dealer);
    }

    public void calculateProfit(double rate, Dealer dealer) {
        profit.add(bettingAmount.calculate(rate));
        dealer.calculateProfit(profit);
    }

    public void calculateProfitWithScore(Dealer dealer) {
        int result = Integer.compare(cards.calculateScore(), dealer.getScore());
        if (result > 0) {
            calculateProfit(1, dealer);
        }
        if (result < 0) {
            calculateProfit(-1, dealer);
        }
    }
}