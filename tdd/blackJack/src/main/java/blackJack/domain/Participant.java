package blackJack.domain;

public interface Participant {
    void setBettingAmount(BettingAmount amount);
    void setInitCards(Cards cards);
    void pickCard(Card card);
    String showCards();
    String getCardsInfo();
    int getResult();
    String showResult();
    boolean canPickCard();
}
