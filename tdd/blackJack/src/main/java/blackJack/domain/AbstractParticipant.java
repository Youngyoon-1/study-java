package blackJack.domain;

public abstract class AbstractParticipant implements Participant{
    private Rule rule = Rule.PLAYING;
    private BettingAmount amount;
    private Cards cards;

    @Override
    public void pickCard(Card card) {
        cards.add(card);
        if (cards.getSum() > 21) {
            this.rule = Rule.BUST;
        }
    }

    @Override
    public void setInitCards(Cards cards) {
        this.cards = cards;
        if (cards.isBlackJack()) {
            this.rule = Rule.BLACKJACK;
        }
    }

    @Override
    public void setBettingAmount(BettingAmount amount) {
        if (this.amount != null) {
            this.amount.calculate(amount);
            return;
        }
        this.amount = amount;
    }

    @Override
    public String getCardsInfo() {
        return cards.getCardsInfo();
    }

    @Override
    public int getResult() {
        int minimumResult = cards.getSum();
        if (cards.isBlackJack()) {
            return 21;
        }
        if (cards.hasAceCard()) {
            return calculateResult(minimumResult);
        }
        return minimumResult;
    }

    private int calculateResult(int minimumResult) {
        int maximumResult = minimumResult + 10;
        if (maximumResult > 21) {
            return minimumResult;
        }
        return maximumResult;
    }

    @Override
    public boolean canPickCard() {
        return cards.canPickCard();
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public boolean isBust() {
        return rule.isBust();
    }

    @Override
    public BettingAmount getBettingAmount() {
        return amount;
    }

    @Override
    public boolean isBlackJack() {
        return rule.isBlackJack();
    }

    @Override
    public String getProfits() {
        return this + ": " + amount.amount();
    }
}
