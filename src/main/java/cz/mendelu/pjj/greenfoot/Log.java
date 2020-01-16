package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.ClueLog;
import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chuprina
 * @version 4
 */
public class Log extends Actor {

    private static Log log = null;
    private Log() {
        setImage(new GreenfootImage(200, 400));
    }

    public static Log getLog(){
        if(log == null) {
            log = new Log();
        }
        return log;
    }

    public static boolean isLogExist() {
        return log != null;
    }

    @Override
    public void act() {

        ClueLog log = GameWorld.game.getClueLog();
        if(!log.isDone()) {
            String current = log.getCurrentWord();
            int unguessedCounter = log.getUnguessedCounter();
            int currentCounter = log.getWordCounter(current);
            HashMap<String, Integer> wordsToGuess = log.getWordsToGuess();
            Map<String, Integer> allWords = log.getWordList();

            int height = 400, i = 0;
            for (String word : wordsToGuess.keySet()) {
                i++;
                height += 30;
                getWorld().showText(word, 1200, height);
                getWorld().showText(wordsToGuess.get(word) +  ":", 1050, height);
                if (i >= 2) {
                    i = 0;
                    height = 400;
                }
            }
        } else {
            getWorld().showText("Done", 90, 200);
        }
    }
}
