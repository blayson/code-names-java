package cz.mendelu.pjj.greenfoot;

import greenfoot.Actor;


/**
 * @author Chuprina
 * @version 4
 */
public class TimePool extends Actor {
    public int num;
    public int x;
    public int y;
    public boolean isChecked = false;

    TimePool(int num, int x, int y) {
        this.x = x;
        this.y = y;
        this.num = num;
        setImage("time.png");
        getImage().scale(50,50);
    }



    @Override
    public void act() {
//        setImage("check-mark.png");
////        getImage().scale(50,50);
    }

    public void check() {
        isChecked = true;
    }


    public void setChecked() {
        setImage("check-mark.png");
        getImage().scale(50,50);
    }
}
