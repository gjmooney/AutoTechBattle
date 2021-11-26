package main.java.siliconsim.players;

public class RealEstateStartUp extends StartUp {

    /**
     * Basic constructor for real estate start-ups.
     */
    public RealEstateStartUp() {
        super();
        this.setName("Real Estate");
        this.init();
    }

    public RealEstateStartUp(String name) {
        super(name);
        this.init();
    }

    /**
     * Initializer for real estate start-ups.
     * Sets type and initial stats
     */
    public void init() {
        this.setType(Type.REAL_ESTATE);
        this.setNetIncome(150000);
        this.setMaxRevenue(100);
        this.setMarketShare(50);
        this.setCritChance(15);
    }
}

