package blackJack.domain;

import java.util.List;

public interface Participant {
    void initCards(Cards cards);
    String showCard();
}
