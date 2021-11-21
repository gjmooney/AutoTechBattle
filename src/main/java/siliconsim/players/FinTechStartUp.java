package main.java.siliconsim.players;

public class FinTechStartUp extends StartUp {

    public FinTechStartUp() {
        super();
        this.setName("Fin Tech");
        this.init();
    }

    public FinTechStartUp(String name) {
        super(name);
        this.init();
    }

    public void init() {
        this.setType(Type.FIN_TECH);
        this.setAttack(50);
        this.setHealth(200);
        this.setDefense(50);
        this.setCritChance(18);
    }
}
