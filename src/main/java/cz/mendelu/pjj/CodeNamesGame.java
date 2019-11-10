package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Game;

public class CodeNamesGame implements Game {
   private Level level;
   private Player player;
   private ClueLog[] log;
   public Turn currentTurn;

   public CodeNamesGame(Level level, Player player, ClueLog[] log, Turn currentTurn) {
      this.level = level;
      this.player = player;
      this.log = log;
      this.currentTurn = currentTurn;
   }

   public Level getCurrentLevel() {
      throw new UnsupportedOperationException("Does not implemented yet");

   }

   public void endGame() {

      throw new UnsupportedOperationException("Does not implemented yet");
   }

   public int checkClueLog() {
      throw new UnsupportedOperationException("Does not implemented yet");
   }

   public void setLog(ClueLog[] log) {
      this.log = log;
   }
}
