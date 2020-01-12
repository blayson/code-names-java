package cz.mendelu.pjj;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.greenfoot.Game;

public class CodeNamesRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(CodeNamesRunner.class,
                // 3. Prepare the configuration for the runner based on the world class
                Configuration.forWorld(Game.class)
                        // Set the project name as you wish
                        .projectName("Code names: duet")
//                        .hideControls(true)
        );
    }
}
