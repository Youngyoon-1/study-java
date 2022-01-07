package blackJack.veiw;

import blackJack.domain.BlackJackGame;

public class ResultView {

    public static void initCards(BlackJackGame blackJackGame) {
        emptyLine();
        blackJackGame.initCards();
        System.out.println(blackJackGame.getNames() + "에게 2장의 나누었습니다.");
        System.out.println(blackJackGame.showDealerCard());
        blackJackGame.showPlayersCards().forEach(System.out::println);
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void showResult(BlackJackGame blackJackGame) {
        emptyLine();
        System.out.println(blackJackGame.showResult());
        blackJackGame.showPlayersResult().forEach(System.out::println);
    }

    public static void showProfits(BlackJackGame blackJackGame) {
        emptyLine();
        blackJackGame.calculateProfits();
        System.out.println("## 최종 수익");
        System.out.println(blackJackGame.showDealerProfit());
        blackJackGame.showPlayersProfit().forEach(System.out::println);
    }
}
