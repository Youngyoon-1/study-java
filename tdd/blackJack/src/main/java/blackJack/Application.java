package blackJack;

import blackJack.domain.Participants;
import blackJack.veiw.InputView;
import blackJack.veiw.ResultView;

public class Application {
    public static void main(String[] args) {
        Participants participants = InputView.initPlayer();
        ResultView.initCards(participants);
        InputView.pickCard(participants);
    }
}
