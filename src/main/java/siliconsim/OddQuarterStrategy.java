package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

import java.util.LinkedList;

public interface OddQuarterStrategy {
    void doEvent(LinkedList<StartUp> startUps);
}
