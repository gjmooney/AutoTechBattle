package main.java.siliconsim.players;

public class HealthCareStartUp extends StartUp {

    public HealthCareStartUp() {
        super();
        this.setName("Health Care");
        this.setType(Type.HEALTH_CARE);
        this.setAttack(100);
        this.setHealth(100);
        this.setDefense(100);
    }

    public HealthCareStartUp(String name) {
        super(name);
        this.setType(Type.HEALTH_CARE);
        this.setAttack(100);
        this.setHealth(100);
        this.setDefense(100);
    }
}
