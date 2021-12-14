package subway;

import subway.mapper.IndexPageMapper;
import view.IndexView;

public class Adapter {
    public void run() {
        while (true) {
            String request = IndexView.print();
            IndexPageMapper.map(request);
        }
    }
}
