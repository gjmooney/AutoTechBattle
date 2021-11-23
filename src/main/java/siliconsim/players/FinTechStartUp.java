package main.java.siliconsim.players;

public class FinTechStartUp extends StartUp {

    /**
     * Basic constructor for fin tech start-ups.
     */
    public FinTechStartUp() {
        super();
        this.setName("Fin Tech");
        this.init();
    }

    public FinTechStartUp(String name) {
        super(name);
        this.init();
    }

    /**
     * Initializer for fin tech start-ups.
     * Sets type and initial stats
     */
    public void init() {
        this.setType(Type.FIN_TECH);
        this.setAttack(50);
        this.setMaxHealth(200);
        this.setDefense(50);
        this.setCritChance(18);
    }
}
