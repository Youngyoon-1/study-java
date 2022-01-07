package blackJack.domain;

public interface Participant {
    void initCards(Cards cards);
    String showCard();
    void pickCard(Cards cards);
    boolean canPickCard();
    String showResult();
    void finishGame();
    String showProfit();
}