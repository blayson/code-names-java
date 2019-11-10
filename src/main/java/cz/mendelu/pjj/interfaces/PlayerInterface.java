package cz.mendelu.pjj.interfaces;

import cz.mendelu.pjj.CodeNamesGame;

public interface PlayerInterface {
    public boolean checkWord(byte position);

    public void endGame(CodeNamesGame game);
}
