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
        this.setAttack(150);
        this.setMaxHealth(100);
        this.setDefense(50);
        this.setCritChance(15);
    }
}

