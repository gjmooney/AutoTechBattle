package players.java;

import attacks.java.AttackStrategy;

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


    abstract void setAttackStrategy(AttackStrategy strategy);
    abstract void doAttack();
    abstract void getAttacked(StartUp attacker);
    abstract void battleOver();
    abstract void evolve();

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
