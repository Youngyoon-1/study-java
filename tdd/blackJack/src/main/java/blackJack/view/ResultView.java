package blackJack.view;

import blackJack.domain.Participants;

public class ResultView {
    public static void initCards(Participants participants) {
        emptyLine();
        System.out.println("딜러와 " + participants.getPlayersName() + "에게 2장의 카드를 나누었습니다.");
        participants.pickCards();
        participants.participants().forEach(participant -> System.out.println(participant.showCards()));
    }

    private static void emptyLine() {
        System.out.println();
    }
}
