package subway.mapper;

import java.util.Arrays;

import subway.controller.SubwayController;
import view.AdminSectionView;

public enum AdminSectionPageMapper {
    ADD("1", AdminSectionPageMapper::mapToAdd),
    DELETE("2", AdminSectionPageMapper::mapToDelete),
    BACK("B", AdminSectionPageMapper::mapToBack)
    ;

    static final SubwayController subwayController = SubwayController.getInstance();

    private final String value;
    private final Mappable mappable;

    AdminSectionPageMapper(String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    public static void map(String request) {
        Arrays.stream(AdminSectionPageMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mappable.map();
    }

    private static void mapToBack() {
        return;
    }

    private static void mapToDelete() {
        try {
            String lineName = AdminSectionView.printMainDeleteSection();
            String stationName = AdminSectionView.printPageDeleteByStationName();
            subwayController.deleteSection(lineName, stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.SECTION.mappable.map();
        }
    }

    private static void mapToAdd() {
        try {
            String lineName = AdminSectionView.printMainAddSection();
            String stationName = AdminSectionView.printPageAddSectionByStationName();
            String order = AdminSectionView.printPageAddSectionByOrder();
            subwayController.addSection(lineName, stationName, order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.SECTION.mappable.map();
        }
    }
}
