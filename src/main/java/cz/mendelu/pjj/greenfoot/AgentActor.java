package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.EnemyAgent;
import cz.mendelu.pjj.domain.FriendlyAgent;
import cz.mendelu.pjj.domain.InnocentAgent;
import cz.mendelu.pjj.domain.interfaces.Agent;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

public class AgentActor extends Actor {
    private static String IMAGE_SUFIX = ".png";
//    private static String IMAGE_SELECTED_SUFIX = "-red.png";
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

//    @Override
//    public void act() {
//        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
//        if (mouseInfo != null) {
//            Actor actor = mouseInfo.getActor();
//            AgentActor agentActor = (AgentActor)actor;
//                if (isLeftClickOnThisActor(mouseInfo, agentActor)) {
//                    this.setSelected();
//                    //} else if (isLeftClickOnField(mouseInfo, rpgActor) && selectedHrdinaActor == this) {
//                    //    this.moveToLocation(mouseInfo.getX(), mouseInfo.getY());
//                } else if (isRightClickOnThisActor(mouseInfo, agentActor) && selectedHrdinaActor != this) {
//                    this.executeFightWith(selectedHrdinaActor);
//                }
//            }
//        }
//    }
}
