package racingCar.domain;

public class Name {
    public static final int LENGTH_LIMITER = 5;

    private final String name;

    public Name(String name) {
        checkLength(name);
        this.name= name;
    }

    private void checkLength(String s){
        if(isOverLength(s)){
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private boolean isOverLength(String s){
        return s.length() > LENGTH_LIMITER;
    }

    public String report() {
        return name;
    }
}
