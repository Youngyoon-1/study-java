package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    public static final int THRESHOLD_COUNT = 1;
    public static final int THRESHOLD_STATION_COUNT = 2;

    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void add(Station station) {
        checkIsNewStation(station);
        stations.add(station);
    }

    private void checkIsNewStation(Station station) {
        if(stations.stream().anyMatch(originalStation -> originalStation.equals(station))) {
            throw new IllegalArgumentException("[ERROR] 노선 안에 이미 존재하는 역입니다.");
        }
    }

    public void add(Station station, int order) {
        checkIsNewStation(station);
        checkStationOrder(order);
        stations.add(order - 1, station);
    }

    public void checkStationOrder(int order) {
        if(isOverThanThresholdOrder(order)) {
            throw new IllegalArgumentException("[ERROR] 최대 순서는 존재하는 역의 갯수에 2를 더한 값을 넘 수 없습니다. ");
        }
    }

    private boolean isOverThanThresholdOrder(int order) {
        return order > stations.size() + THRESHOLD_COUNT;
    }

    public void delete(Station station) {
        checkExistStation(station);
        checkStationsCount();
        stations.remove(station);
    }

    private void checkStationsCount() {
        if(stations.size() <= THRESHOLD_STATION_COUNT) {
            throw new IllegalArgumentException("[ERROR] 노선은 최소 두개의 역으로 구성돼야합니다.");
        }
    }

    public void checkExistStation(Station inputStation) {
        stations.stream()
            .filter(station -> station.equals(inputStation))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 노선에 존재하지 않는 역 입니다."));
    }

    public boolean hasStation(Station station) {
        return stations.contains(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Line line = (Line)o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
