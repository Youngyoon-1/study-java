package blackJack.domain;

import java.util.List;

public class BlackJackGame {
    private final Players players;
    private final Dealer dealer;
    private final Deck deck;

    public BlackJackGame(Players players, PickStrategy pickStrategy) {
        deck = new Deck(pickStrategy);
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

    public List<Player> players() {
        return players.players();
    }

    public void pickCard(Player player) {
        player.pickCard(deck.getCard(1));
    }

    public void dealerPickCard() {
        if (dealer.canPickCard()) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            dealer.pickCard(deck.getCard(1));
        }
    }

    public String showResult() {
        return dealer.showResult();
    }

    public List<String> showPlayersResult() {
        return players.showResults();
    }

    public String showDealerProfit() {
        return dealer.showProfit();
    }

    public List<String> showPlayersProfit() {
        return players.showPlayersProfit();
    }

    public void calculateProfits() {
        players.calculateProfits(dealer);
    }

    public void finishGame() {
        dealer.finishGame();
        players.finishGame();
    }
}