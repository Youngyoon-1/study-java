package blackJack.domain;

import java.util.Collections;
import java.util.List;

public class Dealer extends AbstractParticipant {
    @Override
    public List<String> showCard() {
        return Collections.singletonList(cards.showCard().get(0));
    }

    @Override
    public String toString() {
        return "딜러";
    }
}
