package cz.mendelu.pjj.interfaces;

public interface GameState {
    void nextState();

    void prevState();

    void exit();

    void printStatus();
}
