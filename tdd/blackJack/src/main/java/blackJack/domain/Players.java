package blackJack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> players() {
        return players;
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
}
