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
        setNetIncome(getNetIncome() + 10);
        setMarketShare(getMarketShare() + 10);
        setMaxRevenue(getMaxRevenue() + 100);
        setEvolution(Evolutions.VC_BAIT);
    }

    @Override
    public void listAttacks() {
        super.listAttacks();
        System.out.println("3) Hire Business Consultants");
    }
}
