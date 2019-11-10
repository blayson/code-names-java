package cz.mendelu.pjj.interfaces;


public interface Agent {
    /**
     * Tato metoda se vola pokud je vybran Agent a podle toho jaky typ agentu to je
     * bude se provadet nejaka akce
     */
    public void action(PlayerInterface player, Game game);
    public String getInformation();
}
