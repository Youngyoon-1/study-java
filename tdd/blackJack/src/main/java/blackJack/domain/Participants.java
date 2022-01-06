package blackJack.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<Participant> participants = new ArrayList<>();

    public Participants(List<Participant> participants) {
        this.participants.add(new Dealer());
        this.participants.addAll(participants);
    }
}
