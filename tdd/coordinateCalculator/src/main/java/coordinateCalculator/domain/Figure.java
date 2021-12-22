package coordinateCalculator.domain;

import java.util.List;

import coordinateCalculator.dto.Result;

public interface Figure<T> {
    String COORDINATE_DELIMITER = "-";

    T calculate();

    List<Point> coordinates();

    default Result getResult() {
        return new Result(this.toString(), calculate());
   }
}
