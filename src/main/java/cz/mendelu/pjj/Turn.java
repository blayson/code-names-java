package cz.mendelu.pjj;

public enum Turn {
    PLAYER,
    OPPONENT;

    public  Turn toNext(){
        int ordinalCurrent = (ordinal()+1) % values().length;
        return values()[ordinalCurrent];
    }
}
