package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.CodeNamesGame;
import greenfoot.World;

import java.io.Serializable;

/**
 * @author But
 * @version 4
 */
public class Game extends World implements Serializable {

    public static final CodeNamesGame game = CodeNamesGame.getDefaultGame();

    /**
     * Create a new world with 25x12 cells and
     * with a cell size of 70x70 pixels
     */
    public Game() {
        super(1600, 900, 1);
        setBackground("background.png");
        addObject(new BoardActor(), getWidth()/2, getHeight()/2);
        addObject(new SaveActor(), 60, 50);
    }



}
