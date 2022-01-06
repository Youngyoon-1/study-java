package blackJack.domain;

import java.util.List;

public class Dealer extends AbstractParticipant {
    @Override
    public List<String> showCard() {
        return null;
    }

    @Override
    public String toString() {
        return "딜러";
    }
}
