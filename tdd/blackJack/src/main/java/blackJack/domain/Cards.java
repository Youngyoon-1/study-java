package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private List<Card> cards = new ArrayList<>();

    public Cards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String getCardsInfo() {
        return cards.stream().map(Card::toString).collect(Collectors.joining(", "));
    }

    public int getSum() {
        return cards.stream().mapToInt(Card::getNumber).sum();
    }

    public String getOneCardInfo() {
        return cards.get(0).toString();
    }

    public boolean canPickCard() {
        if (isBlackJack()) {
            return false;
        }
        return getSum() < 21;
    }

    public boolean isBlackJack() {
        return cards.size() == 2 && hasTenCard() && hasAceCard();
    }

    private boolean hasTenCard() {
        return cards.stream().anyMatch(Card::isTen);
    }

    public boolean hasAceCard() {
        return cards.stream().anyMatch(Card::isAce);
    }
}
