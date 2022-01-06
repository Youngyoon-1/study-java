package blackJack.domain;

import java.util.Collections;
import java.util.Stack;

public class RandomPickStrategy implements PickStrategy {
    @Override
    public Stack<Card> shuffle(Stack<Card> cards) {
        Collections.shuffle(cards);
        return cards;
    }
}
