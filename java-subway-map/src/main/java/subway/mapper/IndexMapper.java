package subway.mapper;

import java.util.Arrays;

import subway.domain.SubwayController;
import view.AdminLineView;
import view.AdminSectionView;

public enum IndexMapper {
    STATION("1", IndexMapper::stationMainMapping),
    LINE("2", IndexMapper::lineMainMapping),
    SECTION("3", IndexMapper::sectionMainMapping),
    SUBWAY_MAP("4", IndexMapper::subwayMapMainMapping),
    QUIT("Q", IndexMapper::quitMapping);

    static SubwayController subwayController = SubwayController.getInstance();

    String value;
    Mapperable mapperable;

    IndexMapper(String value, Mapperable mapperable) {
        this.value = value;
        this.mapperable = mapperable;
    }

    public static void mapping(String request) {
        Arrays.stream(IndexMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mapperable.mapping();
    }

    static void quitMapping() {
        System.exit(0);
    }

    static void subwayMapMainMapping() {
        subwayController.getSubwayMap();
    }

    static void sectionMainMapping() {
        String request = AdminSectionView.printMain();
        AdminSectionMapper.mapping(request);
    }

    static void lineMainMapping() {
        String request = AdminLineView.printMain();
        AdminLineMapper.mapping(request);
    }

    static void stationMainMapping() {
        String request = subwayController.adminStationMain();
        AdminStationMapper.mapping(request);
    }
}
