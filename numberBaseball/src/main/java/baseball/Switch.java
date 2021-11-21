package baseball;

public enum Switch {
    RESTART,
    END;

    public boolean isRestart(){
        return this == RESTART;
    }
}
