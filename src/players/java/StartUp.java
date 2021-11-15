package players.java;

import attacks.java.AttackStrategy;
import main.java.Constants;

// Template pattern, uses Strategy pattern for attacks
public abstract class StartUp {
    String name;
    String owner; // TechGiant
    Type type; // maybe
    int level;
    int exp;
    int netIncome; // Attack
    int revenue; // Health
    int marketShare; // Defense
    AttackStrategy attackStrategy;


    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public void doAttack(StartUp target) {
        int damage = attackStrategy.attack(netIncome);

        //Attack does extra damage if it is the same type
        if (type.equals(attackStrategy.getType())) {
            damage *= Constants.SAME_TYPE_ATTACK_BONUS;
        }

        target.getAttacked(damage);
    }

    public void getAttacked(int damage) {
        int healthLost = damage - marketShare;
        setRevenue(revenue - healthLost);
    }

    void battleOver(){

    }

    void evolve() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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
