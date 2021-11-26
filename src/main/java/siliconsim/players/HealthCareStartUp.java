package main.java.siliconsim.players;

public class HealthCareStartUp extends StartUp {

    /**
     * Basic constructor for health care start-ups.
     */
    public HealthCareStartUp() {
        super();
        this.setName("Health Care");
        this.init();
    }

    public HealthCareStartUp(String name) {
        super(name);
        this.init();
    }

    /**
     * Initializer for health care start-ups.
     * Sets type and initial stats
     */
    public void init() {
        this.setType(Type.HEALTH_CARE);
        this.setNetIncome(100);
        this.setMaxRevenue(100);
        this.setMarketShare(100);
        this.setCritChance(13);
    }
}
