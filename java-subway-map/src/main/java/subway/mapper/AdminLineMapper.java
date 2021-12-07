package subway.mapper;

import java.util.Arrays;

import subway.domain.SubwayController;
import view.AdminLineView;

public enum AdminLineMapper {
    ADD("1", AdminLineMapper::addLineMapping),
    DELETE("2", AdminLineMapper::deleteLineMapping),
    CHECK("3", AdminLineMapper::checkLineMapping),
    BACK("B", AdminLineMapper::backMapping);

    static final SubwayController subwayController = SubwayController.getInstance();

    String value;
    Mapperable mapperable;

    AdminLineMapper(String value, Mapperable mapperable) {
        this.value = value;
        this.mapperable = mapperable;
    }

    public static void mapping(String request) {
        Arrays.stream(AdminLineMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mapperable.mapping();
    }

    private static void backMapping() {
        return;
    }

    private static void checkLineMapping() {
        subwayController.checkLines();
    }

    private static void deleteLineMapping() {
        String request = AdminLineView.printPageDeleteLine();
        subwayController.deleteLine(request);
    }

    private static void addLineMapping() {
        String lineName = AdminLineView.printPageAddLine();
        subwayController.checkLineDuplication(lineName);

        String ascendingStationName = AdminLineView.printPageAddAscendingStation();
        subwayController.checkStationExistence(ascendingStationName);

        String descendingStationName = AdminLineView.printPageDescendingStation();
        checkDuplication(ascendingStationName, descendingStationName);
        subwayController.checkStationExistence(descendingStationName);

        subwayController.addLine(lineName, ascendingStationName, descendingStationName);
    }

    private static void checkDuplication(String ascendingStationName, String descendingStationName) {
        if(ascendingStationName.equals(descendingStationName)) {
            throw new IllegalArgumentException("상행 종점역과 하행 종점역은 같을 수 없습니다.");
        }
    }
}
