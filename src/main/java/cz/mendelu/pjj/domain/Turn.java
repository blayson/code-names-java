package cz.mendelu.pjj.domain;

import java.io.Serializable;

public enum Turn implements Serializable {
    PLAYER,
    OPPONENT;

    public Turn toNext() {
        int ordinalCurrent = (ordinal() + 1) % values().length;
        return values()[ordinalCurrent];
    }
}
