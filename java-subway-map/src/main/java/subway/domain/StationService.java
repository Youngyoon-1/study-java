package subway.domain;

import java.util.List;

public class StationService {
    public void add(String name) {
        StationRepository.addStation(new Station(name));
    }

    public void delete(String name) {
        if(LineRepository.hasStation(name)) {
            throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
        }
        StationRepository.deleteStation(name);
    }

    public List<Station> selectAll() {
        return StationRepository.stations();
    }

    public void checkStationExistence(String stationName) {
        StationRepository.findByName(stationName);
    }
}
