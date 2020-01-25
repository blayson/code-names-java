package cz.mendelu.pjj.greenfoot;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chuprina
 * @version 4
 */
public class ClueButtonActor extends Actor {

    Frame f;

    ClueButtonActor() {
        setImage(new GreenfootImage(150, 70));
        f = new JFrame();
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof ClueButtonActor || actor == null) {
                ClueButtonActor clueButtonActor = (ClueButtonActor) actor;
                if (isLeftClickOnThisActor(mouseInfo, clueButtonActor)) {
                    try {
                        String inputClue = this.showInputBox("Submit a clue for you opponent");
                        String inputCount = this.showInputBox("Submit a count of words for clue (less then 25)");
                        int count = Integer.parseInt(inputCount);
                        if(count <= 0 || count >= 9) {
                            throw new NumberFormatException();
                        }
                        GameWorld.game.setClue(inputClue.trim(), count);
                        if(!Log.isLogExist()) {
                            getWorld().addObject(Log.getLog(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                        }
                        GameWorld.game.nextTurn();
                        getWorld().repaint();
                    } catch (NumberFormatException | NullPointerException e) {
                        JOptionPane.showMessageDialog(f,"Incorrect input.");
                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, ClueButtonActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    private String showInputBox(String text) {
        return JOptionPane.showInputDialog(text);
    }
}
