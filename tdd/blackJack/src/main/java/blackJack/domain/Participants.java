package blackJack.domain;

public class Participants {
    private final Players players;
    private final Dealer dealer;

    public Participants(Players players) {
        dealer = new Dealer();
        this.players = players;
    }
}
