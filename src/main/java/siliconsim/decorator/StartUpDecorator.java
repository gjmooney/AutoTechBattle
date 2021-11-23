package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public abstract class StartUpDecorator extends StartUp implements AttackList {
    protected StartUp evolvedStartUp;

    /**
     * Constructor for start-ups evolution decorator.
     * Implements decorator design pattern
     * Sets stats of evolved startup to original start-ups stats
     * @param evolvedStartUp Start-up being evolved
     */
    public StartUpDecorator(StartUp evolvedStartUp) {
        this.evolvedStartUp = evolvedStartUp;
        setAttack(evolvedStartUp.getAttack());
        setDefense(evolvedStartUp.getDefense());
        setMaxHealth(evolvedStartUp.getMaxHealth());
        setCritChance(evolvedStartUp.getCritChance());
        setType(evolvedStartUp.getType());
        setLevel(evolvedStartUp.getLevel());
        setName(evolvedStartUp.getName());
        setOwner(evolvedStartUp.getOwner());
        setExp(evolvedStartUp.getExp());
        setOwner(evolvedStartUp.getOwner());
    }

    @Override
    public void listAttacks() {
        evolvedStartUp.listAttacks();
    }
}
