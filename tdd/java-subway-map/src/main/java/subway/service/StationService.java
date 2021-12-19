package subway.service;

import java.util.List;

import subway.domain.Station;
import subway.repository.StationRepository;

public class StationService {
    public void add(String name) {
        StationRepository.addStation(new Station(name));
    }

    public void delete(String name) {
        StationRepository.deleteByName(name);
    }

    public List<Station> getStations() {
        return StationRepository.stations();
    }
}
