package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.EnemyAgent;
import cz.mendelu.pjj.domain.FriendlyAgent;
import cz.mendelu.pjj.domain.InnocentAgent;
import cz.mendelu.pjj.domain.interfaces.Agent;
import greenfoot.Actor;

/**
 * @author But
 * @version 4
 */
public class AgentActor extends Actor {
    private static String IMAGE_SUFIX = ".png";
    private static String ENEMY = "agent_enemy";
    private static String FRIENDLY = "agent_green_5";
    private static String BYSTANDER = "agent_bystander";

    private static AgentActor selectedAgent;

    private String imageName;

    private Agent agent;

    private AgentActor(String imageName) {
        this.imageName = imageName;
        this.setImage(imageName + IMAGE_SUFIX);
    }

    public AgentActor(EnemyAgent enemyAgent) {
        this(ENEMY);
        if (enemyAgent != null) {
            this.agent = enemyAgent;
        }
        getImage().scale(150, 80);
    }

    public AgentActor(FriendlyAgent friendlyAgent) {
        this(FRIENDLY);
        if (friendlyAgent != null) {
            this.agent = friendlyAgent;
        }
        getImage().scale(150, 80);
    }

    public AgentActor(InnocentAgent innocentAgent) {
        this(BYSTANDER);
        if (innocentAgent != null) {
            this.agent = innocentAgent;
        }
        getImage().scale(50, 50);
    }
}
