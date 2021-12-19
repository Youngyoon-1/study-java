package subway.mapper;

import java.util.Arrays;

import subway.controller.SubwayController;
import view.AdminStationView;

public enum AdminStationPageMapper {
    ADD("1", AdminStationPageMapper::mapToAdd),
    DELETE("2", AdminStationPageMapper::mapToDelete),
    CHECK("3", AdminStationPageMapper::mapToCheck),
    BACK("B", AdminStationPageMapper::mapToBack)
    ;

    static final SubwayController subwayController = SubwayController.getInstance();

    private final String value;
    private final Mappable mappable;

    AdminStationPageMapper(String value, Mappable mappable) {
        this.value = value;
        this.mappable = mappable;
    }

    public static void map(String request) {
        Arrays.stream(AdminStationPageMapper.values())
            .filter(mapper -> mapper.value.equalsIgnoreCase(request)).findFirst().get().mappable.map();
    }

    private static void mapToBack() {
        return;
    }

    private static void mapToCheck() {
        subwayController.getStations();
    }

    private static void mapToDelete() {
        try{
            String request = AdminStationView.printPageDeleteStation();
            subwayController.deleteStation(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.STATION.mappable.map();
        }
    }

    private static void mapToAdd() {
        try{
            String request = AdminStationView.printPageAddStation();
            subwayController.addStation(request);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            IndexPageMapper.STATION.mappable.map();
        }
    }
}
