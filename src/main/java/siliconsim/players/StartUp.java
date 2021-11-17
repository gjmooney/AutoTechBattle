package main.java.siliconsim.players;

import main.java.siliconsim.attacks.AttackStrategy;
import main.java.siliconsim.Constants;

// Template pattern, uses Strategy pattern for attacks
public abstract class StartUp {
    private String name;
    private TechGiant owner; // TechGiant
    private Type type; // maybe
    private int level;
    private int exp;
    private int attack; // net income
    private int health; // revenue
    private int defense; // market share
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
        int damage = attackStrategy.attack(attack);

        //Attack does extra damage if it is the same type
        if (type.equals(attackStrategy.getType())) {
            damage *= Constants.SAME_TYPE_ATTACK_BONUS;
        }

        if (damage < Constants.MINIMUM_DAMAGE_DONE) {
            damage = Constants.MINIMUM_DAMAGE_DONE;
        }

        return damage;
    }

    public void getAttacked(int damage) {
        int healthLost = damage - getDefense();
        setHealth(getHealth() - healthLost);
    }

    void battleOver(){

    }

    /**
     * Checks if start up has enough exp to level up
     * @return true if start-up gained a level, false otherwise
     */
    public boolean levelCheck() {
        if (level < Constants.MAX_LEVEL) {
            // Start-ups require their level cubed in exp to level up
            if (getExp() >= getLevel() * getLevel() * getLevel()) {
                setLevel(getLevel() + 1);
                return true;
            }
        }
        return false;
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

    public String getOwnerName() {
        return getOwner().getName();
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
}
