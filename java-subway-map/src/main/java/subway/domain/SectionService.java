package subway.domain;

public class SectionService {
    public void add(String lineName, String stationName, String order) {
        LineRepository.addSection(lineName, stationName, Integer.parseInt(order));
    }

    public void delete(String lineName, String stationName) {
        LineRepository.deleteSection(lineName, stationName);
    }

    public void checkStationOrder(String lineName, String order) {
        LineRepository.checkStationOrder(lineName, Integer.parseInt(order));
    }
}
