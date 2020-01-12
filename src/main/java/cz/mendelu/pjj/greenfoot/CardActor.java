package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.*;
import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

import javax.swing.*;
import java.sql.Time;
import java.util.List;

public class CardActor extends Actor {
    String value;
    int x;
    int y;
    int position;
    JFrame f;

    public CardActor(String value, int x, int y, int position) {
        setImage("codenames_card.png");

        this.value = value;
        this.x = x;
        this.y = y;
        this.position = position;

        getImage().scale(150, 85);
        f = new JFrame();
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof CardActor || actor == null) {
                CardActor cardActor = (CardActor) actor;
                if (isLeftClickOnThisActor(mouseInfo, cardActor)) {
                    PlayerInterface pl = Game.game.getCurrentPlayer();
                    KeyMap km = pl.getKeyMap();
                    Agent agent = km.getAgent(position);
                    System.out.println(position);
                    if (agent instanceof FriendlyAgent) {
                        getWorld().addObject(new AgentActor((FriendlyAgent) agent), x, y);
                        agent.action(pl, Game.game, value);
                        getWorld().repaint();
                    } else if (agent instanceof EnemyAgent) {
                        getWorld().addObject(new AgentActor((EnemyAgent) agent), x, y);
                        JOptionPane.showMessageDialog(f,"You loose, game ended.");
                        Agent aaaa =agent.action(pl, Game.game, value);
                        if (aaaa != null) {
                            if (pl != Game.game.getCurrentPlayer()) {
                                List<TimePool> objs = getWorld().getObjects(TimePool.class);
                                for (TimePool time : objs) {
                                    if (!time.isChecked) {
                                        getWorld().addObject(new CheckTimeMark(), time.x, time.y);
                                        time.check();
                                        getWorld().repaint();
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (agent instanceof InnocentAgent) {
                        getWorld().addObject(new AgentActor((InnocentAgent) agent), x, y);
                        agent.action(pl, Game.game, value);
                        if (pl != Game.game.getCurrentPlayer()) {
                            List<TimePool> objs = getWorld().getObjects(TimePool.class);
                            for(TimePool time : objs) {
                                if(!time.isChecked) {
                                    getWorld().addObject(new CheckTimeMark(), time.x, time.y);
                                    time.check();
                                    getWorld().repaint();
                                    break;
                                }
                            }
                        }
                    }
//                    ClueLog log = Game.game.getClueLog();
//                    log.decreaseWordCounter(value);
//                    if (log.getWordCounter(value) <= 0) {
//                        Game.game.nextTurn();
//                        getWorld().addObject(new CheckTimeMark(), );
//                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, CardActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }
}
