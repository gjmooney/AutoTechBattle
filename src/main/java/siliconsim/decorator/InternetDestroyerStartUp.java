package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class InternetDestroyerStartUp extends StartUpDecorator {

    /**
     * Constructor for final evolution of start-ups.
     * Implements decorate design pattern
     * Gives a stat boost
     * @param evolvedStartUp The start-up that is being evolved
     */
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
        System.out.println("3) Hire Business Consultants"
                + "\n4) Undercut Prices");

    }
}
