package main.java.siliconsim;

import main.java.siliconsim.players.TechGiant;

public class CatchNewStartUpStrategy implements OddQuarterStrategy {
    @Override
    public void doEvent(TechGiant techGiant) {
        techGiant.setCatchWildStartUp(true);
    }
}
