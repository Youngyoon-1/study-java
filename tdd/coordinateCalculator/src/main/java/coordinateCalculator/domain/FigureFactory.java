package coordinateCalculator.domain;

import static coordinateCalculator.domain.Figure.*;

public class FigureFactory {
    public static final int LINE_COORDINATE_COUNT = 2;
    public static final int RECTANGLE_COORDINATE_COUNT = 4;
    public static final String ERROR_INVALID_INPUT = "[ERROR] 객체를 생성할 수 없습니다. 입력값을 다시 확인해주세요.";

    public static Figure from(String input) {
        int coordinateCount = input.split(COORDINATE_DELIMITER).length;
        if (coordinateCount == LINE_COORDINATE_COUNT) {
            return new Line(input);
        }
        if (coordinateCount == RECTANGLE_COORDINATE_COUNT) {
            return new Rectangle(input);
        }
        throw new IllegalArgumentException(ERROR_INVALID_INPUT);
    }
}
