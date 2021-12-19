package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.Line;
import subway.domain.Station;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkIsNewLine(line);
        lines.add(line);
    }

    private static void checkIsNewLine(Line line) {
        if(lines.stream().anyMatch(originalLine -> originalLine.equals(line))) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
    }

    public static void deleteLineByName(String name) {
        Line line = getLine(name);
        lines.remove(line);
    }

    public static Line getLine(String name) {
        return lines.stream()
            .filter(line -> line.getName().equals(name))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다."));
    }

    public static void addStation(String lineName, Station station) {
        Line line = getLine(lineName);
        Station targetStation = StationRepository.getStation(station.getName());
        line.add(targetStation);
    }

    public static void addSection(String lineName, Station station, int order) {
        Line line = getLine(lineName);
        line.add(station, order);
    }

    public static void deleteStation(String lineName, Station station) {
        Line line = getLine(lineName);
        line.delete(station);
    }

    public static void checkNewStation(Station station) {
        if(lines.stream().anyMatch(line -> line.hasStation(station))) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
    }
}
