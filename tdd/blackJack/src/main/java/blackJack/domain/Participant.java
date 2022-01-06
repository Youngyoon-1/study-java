package blackJack.domain;

import java.util.List;

public interface Participant {
    void initCards(Cards cards);
    List<String> showCard();
}
