package blackJack.domain;

public class Dealer extends AbstractParticipant {
    @Override
    public String showCard() {
        return this + ": " + cards.showCard().get(0);
    }

    @Override
    public String toString() {
        return "딜러";
    }

    @Override
    public boolean canPickCard() {
        return state.isRunning() && cards.sum() <= 16;
    }

    public boolean isBlackJack() {
        return state.isBlackJack();
    }

    public boolean isBust() {
        return state.isBust();
    }

    public int getScore() {
        return cards.calculateScore();
    }

    public void calculateProfit(Profit profit) {
        this.profit.add(profit.get() * -1);
    }
}