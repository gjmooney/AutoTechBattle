package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class InternetDestroyerStartUp extends StartUpDecorator {

    public InternetDestroyerStartUp(StartUp evolvedStartUp) {
        super(evolvedStartUp);
        setAttack(getAttack() + 10);
        setDefense(getDefense() + 10);
        setMaxHealth(getMaxHealth() + 100);
        setEvolution(Evolutions.INTERNET_DESTROYER);
    }

    @Override
    public void listAttacks() {
        super.listAttacks();
        System.out.println("4) Undercut Prices");

    }
}
