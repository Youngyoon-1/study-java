package blackJack.domain;

import blackJack.veiw.InputView;
import blackJack.veiw.ResultView;

public class BlackJackController {
    public void run() {
        Players players = InputView.initPlayer();
        BlackJackGame blackJackGame = new BlackJackGame(players, new RandomPickStrategy());
        ResultView.initCards(blackJackGame);
        InputView.pickCard(blackJackGame);
        blackJackGame.finishGame();
        ResultView.showResult(blackJackGame);
        ResultView.showProfits(blackJackGame);
    }
}