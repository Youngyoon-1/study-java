package blackJack.domain;

public enum State {
    RUNNING(null),
    STAY(null),
    BUST((player, dealer) -> player.calculateProfit(-1, dealer)),
    BLACKJACK(State::calculateBlackJack),
    FINISH(State::calculateWithDealer);

    private static void calculateBlackJack(Player player, Dealer dealer) {
        if (!dealer.isBlackJack()) {
            player.calculateProfit(1.5, dealer);
        }
    }

    private static void calculateWithDealer(Player player, Dealer dealer) {
        if (dealer.isBust()) {
            player.calculateProfit(1, dealer);
            return;
        }
        if (dealer.isBlackJack()) {
            player.calculateProfit(-1, dealer);
            return;
        }
        player.calculateProfitWithScore(dealer);
    }

    private final CalculateProfit calculateProfit;

    State(CalculateProfit calculateProfit) {
        this.calculateProfit = calculateProfit;
    }

    public static State checkBust(int score) {
        if (score > 21) {
            return BUST;
        }
        return RUNNING;
    }

    public static State initState(int score) {
        if (score == 11) {
            return BLACKJACK;
        }
        return RUNNING;
    }

    public boolean isRunning() {
        return this == RUNNING;
    }

    public State checkFinish() {
        if (this == RUNNING || this == STAY) {
            return FINISH;
        }
        return this;
    }

    public void calculateProfit(Player player, Dealer dealer) {
        this.calculateProfit.calculate(player, dealer);
    }

    public boolean isBlackJack() {
        return this == BLACKJACK;
    }

    public boolean isBust() {
        return this == BUST;
    }
}