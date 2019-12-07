package cz.mendelu.pjj;

import cz.mendelu.pjj.interfaces.Agent;
import cz.mendelu.pjj.interfaces.Game;
import cz.mendelu.pjj.interfaces.PlayerInterface;

import java.util.Objects;

public class Player implements PlayerInterface {

    private String name;
    private KeyMap keyMap;
    private Integer wins;
    private Integer looses;

    public KeyMap getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(KeyMap keyMap) {
        this.keyMap = keyMap;
    }


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
    public boolean checkWord(int position) {
        throw new UnsupportedOperationException("Does not implemented yet");
    }

    @Override
    public void endGame(Game game) {
        System.out.println("YOU LOSE!");
        game.endGame();
    }

    public void endTurn(Game game) {
        game.nextTurn();
    }

    @Override
    public void continueTurn() {

    }

    @Override
    public void chooseAnotherWord() {

    }

    /**
     * Podle vracene hodnoty z metody  <code>checkWord</code> vybere dalsi postup
     * pokud <code>true </code>, zavola metodu <code>getAgent</code>
     * pokud <code>false </code>, bude vyzadovat opakovani vyberu slova
     *
     * @param position prijme pozice a preda tento parametr metode <code>checkWord</code>
     */
    public void allowChoice(byte position) {
        if (checkWord(position)) {
            Agent agent = this.keyMap.getAgent(position);
        }
    }

    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) &&
                keyMap.equals(player.keyMap) &&
                wins.equals(player.wins) &&
                looses.equals(player.looses);
    }

    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, keyMap, wins, looses);
    }

    /**
     * @author But
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", keyMap=" + keyMap +
                ", wins=" + wins +
                ", looses=" + looses +
                '}';
    }
}
