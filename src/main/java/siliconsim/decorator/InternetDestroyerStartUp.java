package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class InternetDestroyerStartUp extends StartUpDecorator {

    public InternetDestroyerStartUp(StartUp evolvedStartUp) {
        super(evolvedStartUp);
        setAttack(getAttack() + 10);
        setDefense(getDefense() + 10);
        setHealth(getHealth() + 100);
    }

    @Override
    public void listAttacks() {
        evolvedStartUp.listAttacks();
        System.out.println("4) Undercut Prices");

    }
}
