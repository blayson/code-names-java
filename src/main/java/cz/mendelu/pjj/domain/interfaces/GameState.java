package cz.mendelu.pjj.domain.interfaces;

public interface GameState {
    void nextState();

    void prevState();

    void exit();

    void printStatus();
}
