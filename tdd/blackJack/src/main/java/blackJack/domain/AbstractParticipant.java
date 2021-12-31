package blackJack.domain;

public abstract class AbstractParticipant implements Participant{
    private Rule rule = Rule.PLAYING;
    private BettingAmount amount;
    private Cards cards;

    @Override
    public void pickCard(Card card) {
        cards.add(card);
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
        this.amount = amount;
    }

    @Override
    public String getCardsInfo() {
        return cards.getCardsInfo();
    }

    @Override
    public int getResult() {
        if (rule.isBlackJack()) {
            return rule.number();
        }
        if (cards.hasAceCard()) {
            return calculateResult();
        }
        return cards.getSum();
    }

    public int calculateResult() {
        return 0;
    }

    @Override
    public boolean canPickCard() {
        if (rule.isBlackJack()) {
            return false;
        }
        return cards.canPickCard();
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
