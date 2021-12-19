package subway.service;

import java.util.List;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.domain.Station;

public class LineService {
    public void delete(String name) {
        LineRepository.deleteLineByName(name);
    }

    public List<Line> getLines() {
        return LineRepository.lines();
    }

    public void addLine(String lineName) {
        LineRepository.addLine(new Line(lineName));
    }

    public void addStation(String lineName, String stationName) {
        LineRepository.addStation(lineName, new Station(stationName));
    }
}
