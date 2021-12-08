package subway.service;

import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {
    public void add(String lineName, String stationName, String order) {
        LineRepository.addSection(lineName, new Station(stationName), Integer.parseInt(order));
    }

    public void delete(String lineName, String stationName) {
        LineRepository.deleteStation(lineName, new Station(stationName));
    }

    public void checkExistLine(String lineName) {
        LineRepository.getLine(lineName);
    }

    public void checkExistStation(String stationName) {
        StationRepository.getStation(stationName);
    }
}
