package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public abstract class StartUpDecorator extends StartUp implements AttackList {
    protected StartUp evolvedStartUp;

    public StartUpDecorator(StartUp evolvedStartUp) {
        this.evolvedStartUp = evolvedStartUp;
    }

    @Override
    public void listAttacks() {
        evolvedStartUp.listAttacks();
    }
}
