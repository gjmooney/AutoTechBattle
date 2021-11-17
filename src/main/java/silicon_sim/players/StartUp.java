package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;
import main.java.silicon_sim.Constants;

// Template pattern, uses Strategy pattern for attacks
public abstract class StartUp {
    private String name;
    private TechGiant owner; // TechGiant
    private Type type; // maybe
    private int level;
    private int exp;
    private int netIncome; // Attack
    private int revenue; // Health
    private int marketShare; // Defense
    private AttackStrategy attackStrategy;

    public StartUp() {
        this.setOwner(null);
        this.setLevel(1);
    }

    public StartUp(String name) {
        this.setName(name);
        this.setOwner(null);
        this.setLevel(1);
    }


    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public int doAttack() {
        int damage = attackStrategy.attack(netIncome);

        //Attack does extra damage if it is the same type
        if (type.equals(attackStrategy.getType())) {
            damage *= Constants.SAME_TYPE_ATTACK_BONUS;
        }

        return damage;
    }

    public void getAttacked(int damage) {
        int healthLost = marketShare - damage;
        setRevenue(revenue - healthLost);
    }

    void battleOver(){

    }

    public void levelCheck() {
        if (level < Constants.MAX_LEVEL) {
            if (getExp() >= getLevel() * getLevel() * getLevel()) {
                level++;
            }
        }
    }

    void evolve() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechGiant getOwner() {
        return owner;
    }

    public void setOwner(TechGiant owner) {
        this.owner = owner;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(int marketShare) {
        this.marketShare = marketShare;
    }
}
