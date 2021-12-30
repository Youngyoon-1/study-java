package blackJack.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    public static final List<Participant> Participants = new ArrayList<>();

    static {
        Participants.add(new Dealer());
    }

    public static void add(Participant participant) {
        Participants.add(participant);
    }
}
