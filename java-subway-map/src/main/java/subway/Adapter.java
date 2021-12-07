package subway;

import subway.domain.SubwayController;
import subway.mapper.IndexMapper;

public class Adapter {
    private final SubwayController subwayController;

    public Adapter() {
        this.subwayController = SubwayController.getInstance();
    }

    public void run() {
        while(true){
            String request = subwayController.index();
            IndexMapper.mapping(request);
        }
    }
}
