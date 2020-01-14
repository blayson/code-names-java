package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.io.GameSaver;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

import java.awt.*;
import java.io.IOException;

public class SaveActor extends Actor {

    SaveActor() {
        setImage(new GreenfootImage(100,100));
        getImage().drawRect(50, 50, 45,30);
        getImage().setColor(new Color(255));
        getImage().drawString("Save", 60,70);
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            int buttonNumber = mouseInfo.getButton();
            if(buttonNumber == 1) {
                try {
                    GameSaver.save(Game.game);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
