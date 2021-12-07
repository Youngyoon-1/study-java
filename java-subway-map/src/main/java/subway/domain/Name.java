package subway.domain;

public class Name {
    public static final int NAME_THRESHOLD_LENGTH = 2;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        checkNull(name);
        checkEmpty(name);
        checkLength(name);
    }

    private void checkLength(String name) {
        if(isLessThanThresholdLength(name)){
            throw new IllegalArgumentException("[ERROR] 역이름은 두글자 이상으로 입력해주세요.");
        }
    }

    private boolean isLessThanThresholdLength(String name) {
        return name.length() < NAME_THRESHOLD_LENGTH;
    }

    private void checkEmpty(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    private void checkNull(String name) {
        if(name == null) {
            throw new IllegalArgumentException("[ERROR] 입력값이 null입니다.");
        }
    }
}
