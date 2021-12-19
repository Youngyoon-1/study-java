package subway.mapper;

import java.util.Arrays;

import subway.controller.SubwayController;
import view.AdminLineView;
import view.AdminSectionView;
import view.AdminStationView;

public enum IndexPageMapper {
    STATION("1", IndexPageMapper::mapToStation),
    LINE("2", IndexPageMapper::mapToLine),
    SECTION("3", IndexPageMapper::mapToSection),
    SUBWAY_MAP("4", IndexPageMapper::mapToSubwayMap),
    QUIT("Q", IndexPageMapper::mapToQuit);

    static final SubwayController subwayController = SubwayController.getInstance();

    final String value;
    final Mappable mappable;

    IndexPageMapper(String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    public static void map(String request) {
        Arrays.stream(IndexPageMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mappable.map();
    }

    static void mapToQuit() {
        System.exit(0);
    }

    static void mapToSubwayMap() {
        subwayController.getSubwayMap();
    }

    static void mapToSection() {
        String request = AdminSectionView.printMain();
        AdminSectionPageMapper.map(request);
    }

    static void mapToLine() {
        String request = AdminLineView.printMain();
        AdminLinePageMapper.map(request);
    }

    static void mapToStation() {
        String request = AdminStationView.printMain();
        AdminStationPageMapper.map(request);
    }
}
