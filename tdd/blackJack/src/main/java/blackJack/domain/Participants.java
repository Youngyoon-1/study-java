package blackJack.domain;

import java.util.List;

public class Participants {
    private final Players players;
    private final Dealer dealer;
    private final Deck deck;

    public Participants(Players players) {
        deck = new Deck(new RandomPickStrategy());
        dealer = new Dealer();
        this.players = players;
    }

    public String showDealerCard() {
        return dealer.showCard();
    }

    public List<String> showPlayersCards() {
        return players.showPlayersCards();
    }

    public String getNames() {
        return "딜러와 " + String.join(", ", players.getNames());
    }

    public void initCards() {
        dealer.initCards(deck.getCard(2));
        players.initCards(deck);
    }
}
