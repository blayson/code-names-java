package cz.mendelu.pjj.interfaces;


import cz.mendelu.pjj.KeyMap;

public interface PlayerInterface {
    public boolean checkWord(int position);

    public void endGame(Game game);

    public KeyMap getKeyMap();

    public void endTurn(Game game);

    void continueTurn();

    void chooseAnotherWord();
}
