package cz.mendelu.pjj.greenfoot;

import cz.mendelu.pjj.domain.CodeNamesGame;
import cz.mendelu.pjj.domain.Word;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.MouseInfo;

public class BoardActor extends Actor {

    BoardActor() {
        setImage("start.png");
        getImage().scale(200, 200);
    }

    @Override
    public void act() {
        MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        if (mouseInfo != null) {
            Actor actor = mouseInfo.getActor();
            if (actor instanceof BoardActor || actor == null) {
                BoardActor boardActor = (BoardActor) actor;
                if (isLeftClickOnThisActor(mouseInfo, boardActor)) {
                    this.startGame();
                }
            }
        }
    }

    private boolean isLeftClickOnThisActor(MouseInfo mouseInfo, BoardActor actor) {
        return actor == this && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    private boolean isRightClickOnThisActor(MouseInfo mouseInfo, BoardActor actor) {
        return actor == this && mouseInfo.getButton() == 3 && mouseInfo.getClickCount() == 0;
    }

    private boolean isLeftClickOnField(MouseInfo mouseInfo, BoardActor actor) {
        return actor == null && mouseInfo.getButton() == 1 && mouseInfo.getClickCount() == 0;
    }

    public void startGame() {
        addCards();
        addButtons();
        getWorld().removeObject(this);
    }

    public void addCards() {
        int x = getWorld().getWidth()/6;
        int y = getWorld().getHeight()/4;
        int heightOffset = getWorld().getHeight()/4;

        int i = 0;
        for (Word word : Game.game.getWordCards()) {
            i = i+1;
            System.out.println(i);
            CardActor card = new CardActor(word.getValue(), x, y, i);
            getWorld().addObject(card, x, y);
            getWorld().showText(word.getValue(), x, y+17);
            int imgWidth = card.getImage().getWidth();
            int imgHeight = card.getImage().getHeight();
            y = y + imgHeight + 10;
            if (y == (imgHeight+10)*5+heightOffset) {
                x += imgWidth+10;
                y = heightOffset;
            }
        }
    }

    public void addButtons() {
        int x = getWorld().getWidth()/2;
        int y = getWorld().getHeight()/6;
        Button button = new Button();
        getWorld().addObject(button, x, y*5+50);
        getWorld().showText("Submit a clue", x, y*5+50);
    }
}
