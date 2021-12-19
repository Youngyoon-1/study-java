package view;

import java.util.List;

import subway.domain.Line;

public class SubwayMapView {
    public static void print(List<Line> lines) {
        System.out.println();
        System.out.println("## 지하철 노선도");
        lines.forEach(line -> {
            System.out.println("[INFO] " + line.getName());
            System.out.println("---");
            line.getStations().forEach(station -> System.out.println("[INFO] " + station.getName()));
            System.out.println();
        });
    }
}
