package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Cars> result;

    public Result() {
         this.result = new ArrayList<>();
    }

    public void add(Cars cars) {
        result.add(cars);
    }

    public List<Cars> getResult() {
        return result;
    }
}
