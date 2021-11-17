package main.java.silicon_sim.players;

public class RealEstateStartUp extends StartUp {

    public RealEstateStartUp() {
        super();
        this.setName("Real Estate");
        this.setType(Type.REAL_ESTATE);
        this.setAttack(150);
        this.setHealth(100);
        this.setDefense(50);
    }

    public RealEstateStartUp(String name) {
        super(name);
        this.setType(Type.REAL_ESTATE);
        this.setAttack(150);
        this.setHealth(100);
        this.setDefense(50);
    }
}

