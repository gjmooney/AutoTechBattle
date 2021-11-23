package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class VcBaitStartUp extends StartUpDecorator {
    public VcBaitStartUp(StartUp evolvedStartUp) {
        super(evolvedStartUp);
        setAttack(getAttack() + 10);
        setDefense(getDefense() + 10);
        setHealth(getHealth() + 100);
        setEvolution(Evolutions.VC_BAIT);
    }

    @Override
    public void listAttacks() {
        super.listAttacks();
        System.out.println("3) Hire Business Consultants");
    }
}
