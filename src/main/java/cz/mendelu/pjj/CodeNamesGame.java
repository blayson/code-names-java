package cz.mendelu.pjj;

public class CodeNamesGame {
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
}
