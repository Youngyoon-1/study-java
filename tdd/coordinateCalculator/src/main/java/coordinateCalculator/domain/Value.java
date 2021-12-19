package coordinateCalculator.domain;

public class Value {
    static final int MAXIMUM_VALUE = 24;
    static final String ERROR_INVALID_VALUE = "[ERROR] 좌표의 숫자 값은 " + MAXIMUM_VALUE + "이하 여야 합니다.";

    private final int value;

    public Value(String parameter) {
        int value = Integer.parseInt(parameter);
        checkValue(value);
        this.value = value;
    }

    private void checkValue(int value) {
        if (value > MAXIMUM_VALUE) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE);
        }
    }
}
