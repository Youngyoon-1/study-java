package blackJack.domain;

import java.util.Stack;

@FunctionalInterface
public interface PickStrategy {
    Stack<Card> shuffle(Stack<Card> cards);
}
