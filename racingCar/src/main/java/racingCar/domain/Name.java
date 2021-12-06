package racingCar.domain;

public class Name {
    private static final int THRESHOLD_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        checkNull(name);
        checkEmpty(name);
        checkLength(name);
    }

    private void checkLength(String name) {
        if(name.length() > THRESHOLD_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름은 " + THRESHOLD_NAME_LENGTH + "글자를 넘길 수 없습니다.");
        }
    }

    private void checkEmpty(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름을 1글자 이상 입력해주세요.");
        }
    }

    private void checkNull(String name) {
        if(name == null) {
            throw new IllegalArgumentException("[ERROR] NULL값이 들어왔네요?");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
