package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        checkDuplication(station);
        stations.add(station);
    }

    private static void checkDuplication(Station station) {
        if(hasDuplication(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
    }

    private static boolean hasDuplication(Station station) {
        return stations.stream().filter(originalStation -> originalStation.equals(station)).findFirst().isPresent();
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean hasStation(String name) {
        return stations.stream().filter(station -> station.equals(name)).findFirst().isPresent();
    }

    public static Station findByName(String stationName) {
        return stations.stream().filter(station -> station.getName().equals(stationName))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다."));
    }
}
