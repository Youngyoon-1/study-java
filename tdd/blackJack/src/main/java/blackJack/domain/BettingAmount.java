package blackJack.domain;

public class BettingAmount {
    public static final int MINIMUM_AMOUNT = 10;
    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 배팅금액은 " + MINIMUM_AMOUNT + "의 배수여야 합니다.";

    private final int bettingAmount;

    public BettingAmount(int bettingAmount) {
        checkAmount(bettingAmount);
        this.bettingAmount = bettingAmount;
    }

    private void checkAmount(int bettingAmount) {
        if (bettingAmount % MINIMUM_AMOUNT != 0 || bettingAmount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT);
        }
    }
}
