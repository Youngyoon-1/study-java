package blackJack.view;

import blackJack.domain.Participants;

import java.util.List;

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

    public static void showResult(Participants participants) {
        emptyLine();
        participants.participants()
                .forEach(participant -> System.out.println(participant.showResult()));
    }

    public static void showProfits(Participants participants) {
        emptyLine();
        System.out.println("## 최종 수익");
        List<String> profits = participants.getProfits();
        profits.forEach(System.out::println);
    }
}

