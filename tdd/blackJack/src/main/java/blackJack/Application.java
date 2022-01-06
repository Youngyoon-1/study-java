package blackJack;

import blackJack.domain.Players;
import blackJack.veiw.InputView;

public class Application {
    public static void main(String[] args) {
        Players players = InputView.initPlayer();
    }
}
