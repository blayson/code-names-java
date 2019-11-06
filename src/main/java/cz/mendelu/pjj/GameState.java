package cz.mendelu.pjj;

interface GameState {
    void nextState();

    void prevState();

    void exit();

    void printStatus();
}
