package blackJack.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Cards cards) {
        this.cards.addAll(cards.cards());
    }

    private List<Card> cards() {
        return this.cards;
    }

    public List<String> showCard() {
        return cards.stream().map(Card::toString).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cards cards1 = (Cards)o;
        return Objects.equals(cards, cards1.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }

    public int sum() {
        return cards.stream().mapToInt(Card::getDenomination).sum();
    }

    public int calculateScore() {
        if (hasAce()) {
            return calculateScoreWithAce();
        }
        return sum();
    }

    private int calculateScoreWithAce() {
        int maxScore = sum() + 10;
        if (maxScore <= 21) {
            return maxScore;
        }
        return sum();
    }

    private boolean hasAce() {
        return cards.stream().anyMatch(Card::isAce);
    }
}