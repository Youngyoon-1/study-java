package blackJack.domain;

public class Player extends AbstractParticipant{
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String showCards() {
        return name + "카드: " + getCardsInfo();
    }

    @Override
    public String showResult() {
        return showCards() + " - 결과: " + getResult();
    }
}
