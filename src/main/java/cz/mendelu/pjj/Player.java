package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.PlayerInterface;

public class Player implements PlayerInterface {

    private String name;

    private KeyMap keyMap;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Kontroluje pokud na dane pozice nekdo.
     * Pokud tam nikdo neni, vrati
     *
     * @param position prijme pozice slova
     * @return <code>true</code> pokud na dane position nikdo neni nebo je tam InnocentAgent
     * nebo return <code>false</code> pokud tam nekdo uz je
     */
    public boolean checkWord(byte position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    public void endTurn(CodeNamesGame game) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    public void endGame(CodeNamesGame game) {
        System.out.println("YOU LOSE!");
        game.endGame();
    }

    /**
     * Podle vracene hodnoty z metody  <code>checkWord</code> vybere dalsi postup
     * pokud <code>true </code>, zavola metodu <code>revealAgent</code>
     * pokud <code>false </code>, bude vyzadovat opakovani vyberu slova
     *
     * @param position prijme pozice a preda tento parametr metode <code>checkWord</code>
     */
    public void allowTurn(byte position) {
        if (checkWord(position)) {
            Agent agent = this.keyMap.getAgent(position);
        }
    }
}
