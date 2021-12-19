package racingCar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    public static final String NAME_DELIMITER = ",";
    private final List<Name> names;

    public Names(String names) {
        validate(names);
        this.names = Arrays.stream(names.split(NAME_DELIMITER)).map(Name::new).collect(Collectors.toList());
    }

    private void validate(String names) {
        checkNull(names);
        checkEmpty(names);
    }

    private void checkEmpty(String names) {
        if(names.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름을 1글자 이상 입력해주세요.");
        }
    }

    private void checkNull(String names) {
        if(names == null) {
            throw new IllegalArgumentException("[ERROR] NULL값이 들어왔네요?");
        }
    }

    public Stream<Name> getStream() {
        return names.stream();
    }
}
