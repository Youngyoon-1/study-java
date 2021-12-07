package subway.mapper;

import java.util.Arrays;

import subway.domain.SubwayController;
import view.AdminStationView;

public enum AdminStationMapper {
    ADD("1", AdminStationMapper::addStationMapping),
    DELETE("2", AdminStationMapper::deleteStationMapping),
    CHECK("3", AdminStationMapper::checkStationMapping),
    BACK("B", AdminStationMapper::backMapping)
    ;

    private static SubwayController subwayController = SubwayController.getInstance();

    String value;
    Mapperable mapperable;

    AdminStationMapper(String value, Mapperable mapperable) {
        this.value = value;
        this.mapperable = mapperable;
    }

    public static void mapping(String request) {
        Arrays.stream(AdminStationMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mapperable.mapping();
    }

    private static void backMapping() {
        return;
    }

    private static void checkStationMapping() {
        subwayController.checkStation();
    }

    private static void deleteStationMapping() {
        String request = AdminStationView.printPageDeleteStation();
        subwayController.adminStationDelete(request);
    }

    private static void addStationMapping() {
        String request = subwayController.adminStationAdd();
        subwayController.adminStationAddResult(request);
    }
}
