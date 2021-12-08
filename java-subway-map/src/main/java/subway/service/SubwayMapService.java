package subway.service;

import java.util.List;

import subway.domain.Line;
import subway.repository.LineRepository;

public class SubwayMapService {
    public List<Line> getSubwayMap() {
        return LineRepository.lines();
    }
}
