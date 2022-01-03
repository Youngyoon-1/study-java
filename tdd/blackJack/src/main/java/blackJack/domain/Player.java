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
        BettingAmount amount = this.getBettingAmount();
        checkBust(amount, dealer);
        checkBlackJack(amount, dealer);
        if (canCalculate(dealer)) {
            calculateProfits(amount, dealer);
        }
    }

    private boolean canCalculate(Participant dealer) {
        return !this.isBust() && !this.isBlackJack() && !dealer.isBust() && !dealer.isBlackJack();
    }

    private void calculateProfits(BettingAmount amount, Participant dealer) {
        if (this.getResult() > dealer.getResult()) {
            int dealerProfits = amount.win() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
        }
        if (this.getResult() < dealer.getResult()) {
            int dealerProfits = amount.lose() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
        }
    }

    private void checkBlackJack(BettingAmount amount, Participant dealer) {
        if (!dealer.isBlackJack() && this.isBlackJack()) {
            int dealerProfits = amount.blackJack() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
        }
        if (dealer.isBlackJack() && !this.isBlackJack()) {
            int dealerProfits = amount.lose() * -1;
            dealer.setBettingAmount(new BettingAmount(dealerProfits));
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
