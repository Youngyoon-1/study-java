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
}
