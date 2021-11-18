package main.java.siliconsim.players;

public class FinTechStartUp extends StartUp{

    public FinTechStartUp() {
        super();
        this.setName("Fin Tech");
        this.setType(Type.FIN_TECH);
        this.setAttack(50);
        this.setHealth(200);
        this.setDefense(50);
        this.setCritChance(18);
    }

    public FinTechStartUp(String name) {
        super(name);
        this.setType(Type.FIN_TECH);
        this.setAttack(50);
        this.setHealth(200);
        this.setDefense(50);
        this.setCritChance(18);
    }
}
