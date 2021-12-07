package subway.domain;

import java.util.List;

public class SubwayMapService {
    public List<Line> get() {
        return LineRepository.lines();
    }
}
