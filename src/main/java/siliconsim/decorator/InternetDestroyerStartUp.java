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
        setNetIncome(getNetIncome() + 10);
        setMarketShare(getMarketShare() + 10);
        setMaxRevenue(getMaxRevenue() + 100);
        setEvolution(Evolutions.INTERNET_DESTROYER);
    }

    @Override
    public void listAttacks() {
        super.listAttacks();
        System.out.println("3) Hire Business Consultants"
                + "\n4) Undercut Prices");

    }
}
