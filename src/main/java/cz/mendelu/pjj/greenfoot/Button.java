package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.ClueLog;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

import javax.swing.*;
import java.awt.*;

public class Button extends Actor {

    Button() {
        setImage(new GreenfootImage(150, 70));
        f = new JFrame();
    }
    Frame f;
    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof Button || actor == null) {
                Button button = (Button) actor;
                if (isLeftClickOnThisActor(mouseInfo, button)) {
                    try {
                        String inputClue = this.showInputBox("Submit a clue for you opponent");
                        String inputCount = this.showInputBox("Submit a count of words for clue (less then 25)");
                        int count = Integer.parseInt(inputCount);
                        if(count <= 0 || count >= 9) {
                            throw new NumberFormatException();
                        }
                        Game.game.setClue(inputClue.trim(), count);
                        if(!Log.isLogExist()) {
                            getWorld().addObject(Log.getLog(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                        } else {
                            getWorld().repaint();
                        }
                        Game.game.nextTurn();
                    } catch (NumberFormatException | NullPointerException e) {
                        JOptionPane.showMessageDialog(f,"Incorrect input.");
                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, Button actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    private String showInputBox(String text) {
        return JOptionPane.showInputDialog(text);
    }
}
