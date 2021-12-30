package blackJack.domain;

public class Dealer extends AbstractParticipant {
    private String getOneCardInfo() {
        return cards().getOneCardInfo();
    }

    @Override
    public String showCards() {
        return "딜러: " + getOneCardInfo();
    }

    @Override
    public String showResult() {
        return "딜러 카드: " + getCardsInfo() + " - 결과: " + getResult();
    }
}
