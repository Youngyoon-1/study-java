package blackJack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants = new ArrayList<>();

    public Participants(List<Participant> participants) {
        this.participants.add(new Dealer());
        this.participants.addAll(participants);
    }

    public String getPlayersName() {
        return participants.stream()
                .filter(participant -> participant instanceof Player)
                .map(Participant::toString)
                .collect(Collectors.joining(", "));
    }

    public void pickCards() {
        participants.forEach(participant -> participant.setInitCards(Deck.getCards()));
    }

    public List<Participant> participants() {
        return participants;
    }

    public List<Participant> getPlayerCanPickCard() {
        return participants.stream()
                .filter(participant -> participant instanceof Player)
                .filter(Participant::canPickCard)
                .collect(Collectors.toList());
    }

    public boolean canPickCardByDealer() {
        return participants.get(0).canPickCard();
    }

    public void pickCardByDealer() {
        participants.get(0).pickCard(Deck.getCard());
    }
}
