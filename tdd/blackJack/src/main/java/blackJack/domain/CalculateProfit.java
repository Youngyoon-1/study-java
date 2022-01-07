package blackJack.domain;

@FunctionalInterface
public interface CalculateProfit {
    void calculate(Player player, Dealer dealer);
}
