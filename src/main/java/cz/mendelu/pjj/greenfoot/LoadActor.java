package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.CodeNamesGame;
import cz.mendelu.pjj.io.GameLoader;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author But
 * @version oprava 4
 */
public class LoadActor extends Actor {

    private Frame f;

    LoadActor() {
        this.f = new JFrame();
        setImage(new GreenfootImage(100, 100));
        getImage().drawRect(50, 50, 45, 30);
        getImage().setColor(new Color(255));
        getImage().drawString("Load", 60, 70);
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof LoadActor || actor == null) {
                LoadActor loadActor = (LoadActor) actor;
                if (isLeftClickOnThisActor(mouseInfo, loadActor)) {
                    try {
                        CodeNamesGame game = GameLoader.load();
                        GameWorld.setGame(game);
                        getWorld().repaint();
                        JOptionPane.showMessageDialog(f, "Game loaded.");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, LoadActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }
}
