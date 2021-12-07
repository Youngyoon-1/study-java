package subway.mapper;

import java.util.Arrays;

import subway.domain.SubwayController;
import view.AdminSectionView;

public enum AdminSectionMapper {
    ADD("1", AdminSectionMapper::addMapping),
    DELETE("2", AdminSectionMapper::deleteMapping),
    BACK("B", AdminSectionMapper::backMapping)
    ;

    static final SubwayController subwayController = SubwayController.getInstance();

    String value;
    Mapperable mapperable;

    AdminSectionMapper(String value, Mapperable mapperable) {
        this.value = value;
        this.mapperable = mapperable;
    }

    public static void mapping(String request) {
        Arrays.stream(AdminSectionMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mapperable.mapping();
    }

    private static void backMapping() {
        return;
    }

    private static void deleteMapping() {
        String lineName = AdminSectionView.printMainDeleteSection();
        subwayController.checkLineExistence(lineName);

        String stationName = AdminSectionView.printPageDeleteByStationName();
        subwayController.checkStationExistenceInLine(lineName, stationName);

        subwayController.deleteSection(lineName, stationName);
    }

    private static void addMapping() {
        String lineName = AdminSectionView.printMainAddSection();
        subwayController.checkLineExistence(lineName);

        String stationName = AdminSectionView.printPageAddSectionByStationName();
        subwayController.checkStationExistence(stationName);

        String order = AdminSectionView.printPageAddSectionByOrder();
        subwayController.checkStationOrder(lineName, order);

        subwayController.addSection(lineName, stationName, order);
    }
}
