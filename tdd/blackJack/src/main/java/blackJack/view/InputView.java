package blackJack.view;

import blackJack.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Participants initPlayer() {
        emptyLine();
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        try {
            List<Participant> participants = generatePlayer(readLine());
            inputBettingAmount(participants);
            return new Participants(participants);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayer();
        }
    }

    private static void inputBettingAmount(List<Participant> participants) {
        participants.forEach(participant -> {
            emptyLine();
            System.out.println(participant + "의 배팅 금액은?");
            String amount = readLine();
            checkAmount(amount);
            participant.setBettingAmount(new BettingAmount(Integer.parseInt(amount)));
        });
    }

    private static void checkAmount(String amount) {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static List<Participant> generatePlayer(String s) {
        checkNames(s);
        List<Participant> participants = new ArrayList<>();
        Arrays.asList(s.split(",")).forEach(name -> participants.add(new Player(name)));
        return participants;
    }

    private static void checkNames(String names) {
        String regex = "[a-zA-Z]+(,[a-zA-Z]+)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(names);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 양식에 맞도록 다시 입력해주세요.");
        }
    }

    private static String readLine() {
        return scanner.nextLine().replace(" ", "");
    }

    private static void emptyLine() {
        System.out.println();
    }

    public static void pickCard(Participants participants) {
        emptyLine();
        participants.getPlayerCanPickCard()
                .forEach(participant -> {
                    System.out.println(participant.toString() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
                    mapRequest(participant, readLine());
                });
    }

    private static void mapRequest(Participant participant, String request) {
        if (request.equalsIgnoreCase("y")) {
            participant.pickCard(Deck.getCard());
            System.out.println(participant.showCards());
        }
        
        if (request.equalsIgnoreCase("n")) {
            System.out.println(participant.showCards());
        }
    }
}