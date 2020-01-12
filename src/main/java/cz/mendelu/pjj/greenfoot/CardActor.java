package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.EnemyAgent;
import cz.mendelu.pjj.domain.FriendlyAgent;
import cz.mendelu.pjj.domain.InnocentAgent;
import cz.mendelu.pjj.domain.KeyMap;
import cz.mendelu.pjj.domain.interfaces.Agent;
import cz.mendelu.pjj.domain.interfaces.PlayerInterface;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

import javax.swing.*;

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
                    } else if (agent instanceof EnemyAgent) {
                        getWorld().addObject(new AgentActor((EnemyAgent) agent), x, y);
                        JOptionPane.showMessageDialog(f,"You loose, game ended.");
                        agent.action(pl, Game.game, value);
                    } else if (agent instanceof InnocentAgent) {
                        getWorld().addObject(new AgentActor((InnocentAgent) agent), x, y);
                        agent.action(pl, Game.game, value);
                    }
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, CardActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }
}
