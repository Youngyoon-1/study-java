package blackJack.domain;

import java.util.Objects;

public class Player {
    private final PlayerName name;
    private BettingAmount bettingAmount;

    public Player(PlayerName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setBettingAmount(BettingAmount bettingAmount) {
        this.bettingAmount = bettingAmount;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
