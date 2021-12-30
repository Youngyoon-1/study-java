package blackJack.domain;

public abstract class AbstractParticipant implements Participant{
    private BettingAmount amount;
    private Cards cards;

    @Override
    public void pickCard(Card card) {
        cards.add(card);
    }

    @Override
    public void setInitCards(Cards cards) {
        this.cards = cards;
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
        return cards.getSum();
    }

    @Override
    public boolean canPickCard() {
        return cards.canPickCard();
    }

    public Cards cards() {
        return cards;
    }
}
