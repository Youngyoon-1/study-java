package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        checkNewStation(station);
        stations.add(station);
    }

    static void checkNewStation(Station inputStation) {
        if(stations.stream().anyMatch(station -> station.equals(inputStation))) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
    }

    public static void deleteByName(String name) {
        Station station = getStation(name);
        LineRepository.checkNewStation(new Station(name));
        stations.remove(station);
    }

    public static Station getStation(String name) {
        return stations.stream()
            .filter(station -> station.getName().equals(name))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역 입니다."));
    }
}
