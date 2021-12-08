package subway.controller;

import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.service.SubwayMapService;
import view.AdminLineView;
import view.AdminSectionView;
import view.AdminStationView;
import view.SubwayMapView;

public class SubwayController {
    private static final SubwayController subwayController = new SubwayController();

    private final StationService stationService;
    private final LineService lineService;
    private final SectionService sectionService;
    private final SubwayMapService subwayMapService;

    private SubwayController() {
        stationService = new StationService();
        lineService = new LineService();
        sectionService = new SectionService();
        subwayMapService = new SubwayMapService();
    }

    public static SubwayController getInstance() {
        return subwayController;
    }

    public void addStation(String name) {
        stationService.add(name);
        AdminStationView.printResultPageAddStation();
    }

    public void deleteStation(String request) {
        stationService.delete(request);
        AdminStationView.printResultPageDeleteStation();
    }

    public void getStations() {
        AdminStationView.printAllStation(stationService.getStations());
    }

    public void deleteLine(String request) {
        lineService.delete(request);
        AdminLineView.printResultPageDeleteLine();
    }

    public void getLine() {
        AdminLineView.printAllLine(lineService.getLines());
    }

    public void deleteSection(String lineName, String stationName) {
        sectionService.delete(lineName, stationName);
        AdminSectionView.printResultPageDeleteSection();
    }

    public void addSection(String lineName, String stationName, String order) {
        sectionService.add(lineName, stationName, order);
        AdminSectionView.printResultPageAddSection();
    }

    public void getSubwayMap() {
        SubwayMapView.print(subwayMapService.getSubwayMap());
    }

    public void addLine(String lineName) {
        lineService.addLine(lineName);
    }

    public void addAscendingStationInLine(String lineName, String ascendingStationName) {
        lineService.addStation(lineName, ascendingStationName);
    }

    public void addDescendingStationInLine(String lineName, String descendingStationName) {
        lineService.addStation(lineName, descendingStationName);
        AdminLineView.printResultPageAddLine();
    }
}