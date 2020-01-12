package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.CodeNamesGame;
import cz.mendelu.pjj.domain.Word;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

import javax.swing.*;

public class Game extends World {

    public static final CodeNamesGame game = CodeNamesGame.getDefaultGame();


    /**
     * Create a new world with 25x12 cells and
     * with a cell size of 70x70 pixels
     */
    public Game() {
        super(1600, 900, 1);
        setBackground("background.png");
        addObject(new BoardActor(), getWidth()/2, getHeight()/2);

    }


    /**
     * Place a number of apples into the world at random places.
     * The number of apples can be specified.
     */
    private void randomActors(int howMany, Class<? extends Actor> actorClass) {
        for (int i = 0; i < howMany; i++) {
            try {
                Actor apple = actorClass.newInstance();
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());
                addObject(apple, x, y);
            } catch (IllegalAccessException | InstantiationException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
