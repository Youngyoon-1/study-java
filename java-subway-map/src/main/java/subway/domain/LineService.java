package subway.domain;

import java.util.List;

public class LineService {
    public void addLine(String lineName, String ascendingStationName, String descendginStaionName) {
        LineRepository.addLine(new Line(lineName));
        LineRepository.addStation(ascendingStationName);
        LineRepository.addStation(descendginStaionName);
    }

    public void delete(String name) {
        LineRepository.deleteLineByName(name);
    }

    public List<Line> selectAll() {
        return LineRepository.lines();
    }

    public void checkLineDuplication(String lineName) {
        LineRepository.checkDuplication(lineName);
    }

    public void checkLineExistence(String lineName) {
        LineRepository.findByName(lineName);
    }

    public void checkStationExistenceInLine(String lineName, String stationName) {
        LineRepository.findStationByName(lineName, stationName);
    }
}
