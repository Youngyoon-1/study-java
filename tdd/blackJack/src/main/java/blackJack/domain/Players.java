package blackJack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<String> getNames() {
        return players.stream().map(Player::toString).collect(Collectors.toList());
    }

    public List<String> showPlayersCards() {
        return players.stream().map(Player::showCard).collect(Collectors.toList());
    }

    public void initCards(Deck deck) {
        players.forEach(player -> player.initCards(deck.getCard(2)));
    }

    public List<Player> players() {
        return players;
    }

    public List<String> showResults() {
        return players.stream().map(AbstractParticipant::showResult).collect(Collectors.toList());
    }

    public List<String> showPlayersProfit() {
        return players.stream().map(AbstractParticipant::showProfit).collect(Collectors.toList());
    }

    public void calculateProfits(Dealer dealer) {
        players.forEach(player -> player.calculateProfit(dealer));
    }

    public void finishGame() {
        players.forEach(Player::finishGame);
    }
}