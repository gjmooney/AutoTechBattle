package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class VcBaitStartUp extends StartUpDecorator {

    /**
     * Constructor for middle evolution of start-ups.
     * Implements decorate design pattern
     * Gives a stat boost
     * @param evolvedStartUp The start-up that is being evolved
     */
    public VcBaitStartUp(StartUp evolvedStartUp) {
        super(evolvedStartUp);
        setAttack(getAttack() + 10);
        setDefense(getDefense() + 10);
        setMaxHealth(getMaxHealth() + 100);
        setEvolution(Evolutions.VC_BAIT);
    }

    @Override
    public void listAttacks() {
        super.listAttacks();
        System.out.println("3) Hire Business Consultants");
    }
}
