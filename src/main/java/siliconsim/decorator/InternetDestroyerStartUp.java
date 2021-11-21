package main.java.siliconsim.decorator;

import main.java.siliconsim.players.StartUp;

public class InternetDestroyerStartUp extends StartUpDecorator{

    public InternetDestroyerStartUp (StartUp evolvedStartUp) {
        super(evolvedStartUp);
    }

    @Override
    public void listAttacks() {
        evolvedStartUp.listAttacks();
        System.out.println("4) Undercut Prices");

    }
}
