package blackJack.domain;

import java.util.List;

public interface Participant <T> {
    void initCards(Cards cards);
    List<String> showCard();
}
