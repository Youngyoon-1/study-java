package blackJack.domain;

public abstract class AbstractParticipant implements Participant {
    protected Cards cards;

    @Override
    public void initCards(Cards cards) {
        this.cards = cards;
    }
}
