package blackJack.domain;

public abstract class AbstractParticipant implements Participant {
    protected State state;
    protected Cards cards;
    protected Profit profit = new Profit();

    @Override
    public void initCards(Cards cards) {
        this.cards = cards;
        state = State.initState(this.cards.sum());
    }

    @Override
    public void pickCard(Cards cards) {
        this.cards.add(cards);
        state = State.checkBust(this.cards.sum());
    }

    @Override
    public String showResult() {
        return this + " 카드: " + String.join(", ", cards.showCard()) + " - 결과: " + cards.calculateScore();
    }

    @Override
    public void finishGame() {
        state = state.checkFinish();
    }

    @Override
    public String showProfit() {
        return this + ": " + profit;
    }
}