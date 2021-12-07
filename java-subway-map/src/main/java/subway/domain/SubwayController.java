package subway.domain;

import view.AdminLineView;
import view.AdminSectionView;
import view.AdminStationView;
import view.IndexView;
import view.SubwayMapView;

public class SubwayController {
    private static final SubwayController subwayController = new SubwayController();
    StationService stationService;
    LineService lineService;
    SectionService sectionService;
    SubwayMapService subwayMapService;

    private SubwayController() {
        stationService = new StationService();
        lineService = new LineService();
        sectionService = new SectionService();
        subwayMapService = new SubwayMapService();
    }

    public static SubwayController getInstance() {
        return subwayController;
    }

    public String index() {
        return IndexView.print();
    }

    public String adminStationMain() {
        return AdminStationView.printMain();
    }

    public String adminStationAdd() {
        return AdminStationView.printPageAddStation();
    }

    public void adminStationAddResult(String name) {
        stationService.add(name);
        AdminStationView.printResultPageAddStation();
    }

    public void adminStationDelete(String request) {
        stationService.delete(request);
        AdminStationView.printResultPageDeleteStation();
    }

    public void checkStation() {
        AdminStationView.printAllStation(stationService.selectAll());
    }

    public void addLine(String lineName, String ascendingStationName, String descendingStationName) {
        lineService.addLine(lineName, ascendingStationName, descendingStationName);
        AdminLineView.printResultPageAddLine();
    }

    public void checkLineDuplication(String lineName) {
        lineService.checkLineDuplication(lineName);
    }

    public void checkStationExistence(String stationName) {
        stationService.checkStationExistence(stationName);
    }

    public void deleteLine(String request) {
        lineService.delete(request);
        AdminLineView.printResultPageDeleteLine();
    }

    public void checkLines() {
        AdminLineView.printAllLine(lineService.selectAll());
    }

    public void checkLineExistence(String lineName) {
        lineService.checkLineExistence(lineName);
    }

    public void deleteSection(String lineName, String stationName) {
        sectionService.delete(lineName, stationName);
        AdminSectionView.printResultPageDeleteSection();
    }

    public void checkStationExistenceInLine(String lineName, String stationName) {
        lineService.checkStationExistenceInLine(lineName, stationName);
    }

    public void addSection(String lineName, String stationName, String order) {
        sectionService.add(lineName, stationName, order);
        AdminSectionView.printResultPageAddSection();
    }

    public void checkStationOrder(String lineName, String stationName) {
        sectionService.checkStationOrder(lineName, stationName);
    }

    public void getSubwayMap() {
        SubwayMapView.print(subwayMapService.get());
    }
}
