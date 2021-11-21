package main.java.siliconsim.players;

public class HealthCareStartUp extends StartUp {

    public HealthCareStartUp() {
        super();
        this.setName("Health Care");
        this.init();
    }

    public HealthCareStartUp(String name) {
        super(name);
        this.init();
    }

    public void init() {
        this.setType(Type.HEALTH_CARE);
        this.setAttack(100);
        this.setHealth(100);
        this.setDefense(100);
        this.setCritChance(13);
    }
}
