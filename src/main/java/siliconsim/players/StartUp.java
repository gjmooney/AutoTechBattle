package main.java.siliconsim.players;

import java.util.Random;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.decorator.AttackList;
import main.java.siliconsim.Constants;
import main.java.siliconsim.decorator.Evolutions;
import main.java.siliconsim.attacks.AttackStrategy;
import main.java.siliconsim.decorator.InternetDestroyerStartUp;
import main.java.siliconsim.decorator.VcBaitStartUp;

// Template pattern, uses Strategy pattern for attacks
public abstract class StartUp implements AttackList {
    private String name;
    private TechGiant owner; // TechGiant
    private Type type; // maybe
    private int level;
    private int exp;
    private int attack; // net income
    private int currentHealth;
    private int maxHealth; // revenue
    private int defense; // market share
    private int critChance; // chance for a critical hit
    private int chanceToMiss;
    private AttackStrategy attackStrategy;
    private Evolutions evolution;

    public StartUp() {
        this.setOwner(null);
        this.setLevel(1);
        this.setChanceToMiss(10);
        this.setEvolution(Evolutions.BRAND_NEW);
    }

    public StartUp(String name) {
        this.setOwner(null);
        this.setLevel(1);
        this.setChanceToMiss(10);
        this.setName(name);
        this.setEvolution(Evolutions.BRAND_NEW);
    }

    @Override
    public void listAttacks() {
        System.out.println("1) Talent Drain"
                + "\n2) Trade Secret Theft");
    }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }

    public int doAttack(int opponentsDefense) {
        Random rand = new Random();
        //int damage = attackStrategy.attack();

        double damage = ((((((getLevel() * 2.0) / 5.0) + 2.0) * (double)(getAttack() / opponentsDefense)) * attackStrategy.attack()) / 50) + 20;

        //Attack does extra damage if it is the same type
        if (type.equals(attackStrategy.getType())) {
            damage *= Constants.SAME_TYPE_ATTACK_BONUS;
        }

        // Generate random number between 1 and 100
        int critNumber = rand.nextInt(100) + 1;

        // attack does double damage if it's a crit
        if (critNumber <= getCritChance()) {
            damage *= 1.5;
            System.out.println("It was a critical hit!");
        }

        // Random multiplier for attack damage between 0.85 and 1.0
        double num = (Math.random() * (1.0 - .85)) + .85;
        damage *= num;

        if (damage < Constants.MINIMUM_DAMAGE_DONE) {
            damage = Constants.MINIMUM_DAMAGE_DONE;
        }

        // do no damage if attack misses
        int missNumber = rand.nextInt(100) + 1;
        if (missNumber <= getChanceToMiss()) {
            damage = 0;
        }

        return (int) Math.ceil(damage);
    }

    public void getAttacked(int damage) {
        System.out.println("RECEIVED DAMAGE " + damage);
        //int healthLost = damage - getDefense();
        setCurrentHealth(getCurrentHealth() - damage);
    }

    void battleOver(){

    }

    /**
     * Checks if start up has enough exp to level up.
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

    public StartUp evolveCheck() {
        StartUp newStUp;
        if (getLevel() == 5) {
            this.setEvolution(Evolutions.VC_BAIT);
            newStUp = new VcBaitStartUp(this);
            evolveCheckHelper(newStUp);
            return newStUp;

        } else if (getLevel() == 10) {
            this.setEvolution(Evolutions.INTERNET_DESTROYER);
            newStUp = new InternetDestroyerStartUp(this);
            evolveCheckHelper(newStUp);
            return newStUp;
        }
        GameLogic.getLogic().setHasEvolved(false);
        return this;
    }

    public void evolveCheckHelper(StartUp startUp) {
        GameLogic.getLogic().setHasEvolved(true);
        if (this.getOwner() != null) {
            this.getOwner().addStartUp(startUp);
            this.getOwner().removeStartUp(this);
            GameLogic.getLogic().addOwnedStartUp(startUp);
            GameLogic.getLogic().removeOwnedStartUp(this);
        } else {
            GameLogic.getLogic().addWildStartUp(startUp);
            GameLogic.getLogic().removeWildStartUp(this);
        }
    }

    public Evolutions getEvolution() {
        return evolution;
    }

    public void setEvolution(Evolutions evolution) {
        this.evolution = evolution;
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

    public String getEvolutionString() {
        return getEvolution().toString().replace("_", " ");
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

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getChanceToMiss() {
        return chanceToMiss;
    }

    public void setChanceToMiss(int chanceToMiss) {
        this.chanceToMiss = chanceToMiss;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }
}
