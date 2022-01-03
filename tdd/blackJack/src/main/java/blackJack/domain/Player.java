package blackJack.domain;

public class Player extends AbstractParticipant{
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String showCards() {
        return name + "카드: " + getCardsInfo();
    }

    @Override
    public String showResult() {
        return showCards() + " - 결과: " + getResult();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void calculateProfits(Participant dealer) {
        if (hasBust(dealer)) {
            checkBust(getBettingAmount(), dealer);
            return;
        }
        if (hasBlackJack(dealer)) {
            checkBlackJack(getBettingAmount(), dealer);
            return;
        }
        calculateProfits(getBettingAmount(), dealer);
    }

    private boolean hasBlackJack(Participant dealer) {
        return this.isBlackJack() || dealer.isBlackJack();
    }

    private boolean hasBust(Participant dealer) {
        return this.isBust() || dealer.isBust();
    }

    private void calculateProfits(BettingAmount amount, Participant dealer) {
        if (this.getResult() > dealer.getResult()) {
            dealer.setBettingAmount(new BettingAmount(amount.win() * -1));
        }
        if (this.getResult() < dealer.getResult()) {
            dealer.setBettingAmount(new BettingAmount(amount.lose() * -1));
        }
        if (this.getResult() == dealer.getResult()) {
            dealer.setBettingAmount(new BettingAmount(amount.initZero()));
        }
    }

    private void checkBlackJack(BettingAmount amount, Participant dealer) {
        if (!dealer.isBlackJack() && this.isBlackJack()) {
            dealer.setBettingAmount(new BettingAmount(amount.blackJack() * -1));
        }
        if (dealer.isBlackJack() && !this.isBlackJack()) {
            dealer.setBettingAmount(new BettingAmount(amount.lose() * -1));
        }
        if (dealer.isBlackJack() && this.isBlackJack()) {
            dealer.setBettingAmount(new BettingAmount(amount.initZero()));
        }
    }

    private void checkBust(BettingAmount amount, Participant dealer) {
        if (this.isBust()) {
            int dealerProfits = amount.lose() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
        }
        if (dealer.isBust() && !this.isBust()) {
            int dealerProfits = amount.win() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
        }
    }
}
