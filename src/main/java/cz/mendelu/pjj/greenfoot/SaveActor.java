package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.io.GameSaver;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Chuprina
 * @version oprava 4
 */
public class SaveActor extends Actor {

    private Frame f;

    SaveActor() {
        this.f = new JFrame();
        setImage(new GreenfootImage(100,100));
        getImage().drawRect(50, 50, 45,30);
        getImage().setColor(new Color(255));
        getImage().drawString("Save", 60,70);
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof SaveActor || actor == null) {
                SaveActor saveActor  = (SaveActor) actor;
                if (isLeftClickOnThisActor(mouseInfo, saveActor)) {
                    try {
                        GameSaver.save(GameWorld.game);
                        JOptionPane.showMessageDialog(f, "Game saved.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, SaveActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }
}
