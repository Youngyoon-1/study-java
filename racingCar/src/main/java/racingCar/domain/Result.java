package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Result {
    private final List<Cars> result;

    public Result() {
         this.result = new ArrayList<>();
    }

    public void add(Cars cars) {
        result.add(cars);
    }

    public Stream<Cars> getStream() {
        return result.stream();
    }
}
