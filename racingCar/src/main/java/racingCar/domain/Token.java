package racingCar.domain;

public class Token {
    private static final int TOKEN_THRESHOLD_NUMBER = 1;

    private int token;

    public Token(String count) {
        validate(count);
        this.token = Integer.parseInt(count);
    }

    private void validate(String count) {
        checkNull(count);
        checkEmpty(count);
        checkType(count);
        checkLessThanThreshold(count);
    }

    private void checkLessThanThreshold(String count) {
        if(Integer.parseInt(count) < TOKEN_THRESHOLD_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + TOKEN_THRESHOLD_NUMBER + " 이상의 숫자를 입력하세요.");
        }
    }

    private void checkType(String count) {
        if(!isDigit(count)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private boolean isDigit(String count) {
        return count.chars().allMatch(Character::isDigit);
    }

    private void checkEmpty(String count) {
        if(count.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 숫자를 한자리 이상 입력해주세요.");
        }
    }

    private void checkNull(String count) {
        if(count == null) {
            throw new IllegalArgumentException("[ERROR] NULL값이 들어왔네요?");
        }
    }

    public int getToken() {
        return token;
    }
}
