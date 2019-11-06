package cz.mendelu.pjj;

public class CodeNames {
    private GameState currentState;

    private void runGame() {
        this.currentState = new MenuGameState();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }
}
