package blackJack.controller;

import blackJack.domain.Participants;
import blackJack.view.ResultView;
import blackJack.view.InputView;

public class BlackJackController {
    public void run() {
        Participants participants = InputView.initPlayer();
        ResultView.initCards(participants);
        InputView.pickCard(participants);
        ResultView.showResult(participants);
    }
}
