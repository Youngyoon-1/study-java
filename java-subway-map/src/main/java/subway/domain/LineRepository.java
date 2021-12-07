package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        checkDuplication(line.getName());
        lines.add(line);
    }

    public static void deleteLineByName(String name) {
        lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void checkDuplication(String name) {
        if(hasDuplication(name)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 이름입니다.");
        }
    }

    private static boolean hasDuplication(String name) {
        System.out.println(name);
        return lines.stream().filter(Objects::nonNull).anyMatch(line -> line.getName().equals(name));
    }

    public static boolean hasStation(String name) {
        return lines.stream().anyMatch(line -> line.hasStation(name));
    }

    public static void addStation(String name) {
        lines.get(lines.size() - 1).add(name);
    }

    public static Line findByName(String name) {
        return lines.stream().filter(line -> line.getName().equals(name)).findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 입력하신 노선은 존재하지 않습니다."));
    }

    public static void addSection(String lineName, String stationName, int order) {
        Line line = findByName(lineName);
        line.add(stationName,order);
    }

    public static void deleteSection(String lineName, String stationName) {
        Line line = findByName(lineName);
        line.delete(stationName);
    }

    public static Line findStationByName(String lineName, String stationName) {
        Line line = findByName(lineName);
        line.checkHasStation(stationName);
        return line;
    }

    public static void checkStationOrder(String lineName, int order) {
        Line line = findByName(lineName);
        line.checkOrderNumber(order);
    }
}
