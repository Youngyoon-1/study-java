package subway.mapper;

import java.util.Arrays;

import subway.controller.SubwayController;
import view.AdminLineView;

public enum AdminLinePageMapper {
    ADD("1", AdminLinePageMapper::mapToAdd),
    DELETE("2", AdminLinePageMapper::mapToDelete),
    CHECK("3", AdminLinePageMapper::mapToCheck),
    BACK("B", AdminLinePageMapper::mapToBack);

    static final SubwayController subwayController = SubwayController.getInstance();

    private final String value;
    private final Mappable mappable;

    AdminLinePageMapper(String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    public static void map(String request) {
        Arrays.stream(AdminLinePageMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mappable.map();
    }

    private static void mapToBack() {
        return;
    }

    private static void mapToCheck() {
        subwayController.getLine();
    }

    private static void mapToDelete() {
        try {
            String request = AdminLineView.printPageDeleteLine();
            subwayController.deleteLine(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.LINE.mappable.map();
        }
    }

    private static void mapToAdd() {
        String lineName = AdminLineView.printPageAddLine();
        addLine(lineName);
        addAscendingStationInLine(lineName);
        addDescendingStationInLine(lineName);
    }

    private static void addDescendingStationInLine(String lineName) {
        try {
            String descendingStationName = AdminLineView.printPageDescendingStation();
            subwayController.addDescendingStationInLine(lineName, descendingStationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            subwayController.deleteLine(lineName);
            IndexPageMapper.LINE.mappable.map();
        }
    }

    private static void addAscendingStationInLine(String lineName) {
        try {
            String ascendingStationName = AdminLineView.printPageAddAscendingStation();
            subwayController.addAscendingStationInLine(lineName, ascendingStationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            subwayController.deleteLine(lineName);
            IndexPageMapper.LINE.mappable.map();
        }
    }

    private static void addLine(String lineName) {
        try {
            subwayController.addLine(lineName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.LINE.mappable.map();
        }
    }
}

