package coordinateCalculator.domain;

import static coordinateCalculator.domain.Figure.*;

public class FigureFactory {

    public static Figure from(String input) {
        int coordinateCount = input.split(COORDINATE_DELIMITER).length;
        return FigureMapper.map(input, coordinateCount);
    }
}
