package cz.mendelu.pjj.domain;

public enum Turn {
    PLAYER,
    OPPONENT;

    public Turn toNext() {
        int ordinalCurrent = (ordinal() + 1) % values().length;
        return values()[ordinalCurrent];
    }
}
