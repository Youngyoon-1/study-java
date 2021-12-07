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

    public boolean hasStation(String name) {
        return stations.stream().filter(station -> station.equals(name)).findFirst().isPresent();
    }

    public void add(String name) {
        checkDuplication(name);
        stations.add(new Station(name));
    }

    public void add(String stationName, int order) {
        checkDuplication(stationName);
        checkOrderNumber(order);
        stations.add(order - 1, new Station(stationName));
    }

    public void checkOrderNumber(int order) {
        if(isOverThanThresholdOrder(order)) {
            throw new IllegalArgumentException("[ERROR] 최대 순서는 존재하는 역의 갯수에 2를 더한 값을 넘 수 없습니다. ");
        }
    }

    private boolean isOverThanThresholdOrder(int order) {
        return order > stations.size() + THRESHOLD_COUNT;
    }

    private void checkDuplication(String name) {
        if(hasStation(name)) {
            throw new IllegalArgumentException("[ERROR] 한 노선에 같은 역은 존재할 수 없습니다.");
        }
    }

    public void delete(String stationName) {
        checkStationsCount();
        Station targetStation = stations.stream().filter(station -> station.getName().equals(stationName))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 노선에 존재하지 않는 역 입니다."));
        stations.remove(targetStation);
    }

    private void checkStationsCount() {
        if(stations.size() <= THRESHOLD_STATION_COUNT) {
            throw new IllegalArgumentException("[ERROR] 노선은 최소 두개의 역으로 구성돼야합니다.");
        }
    }

    public void checkHasStation(String stationName) {
        if(hasStation(stationName)) {
            throw new IllegalArgumentException("[ERROR] 해당 노선에 존재하지 않는 역 입니다.");
        }
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
