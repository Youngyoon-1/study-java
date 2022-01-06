package blackJack.veiw;

import blackJack.domain.Participants;

public class ResultView {

    public static void initCards(Participants participants) {
        emptyLine();
        participants.initCards();
        System.out.println(participants.getNames() + "에게 2장의 나누었습니다.");
        System.out.println(participants.showDealerCard());
        participants.showPlayersCards().forEach(System.out::println);
    }

    private static void emptyLine() {
        System.out.println();
    }
}
