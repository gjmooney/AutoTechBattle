package main.java.siliconsim;

import main.java.siliconsim.players.TechGiant;

import java.util.Scanner;

/**
 * Represents the four quarters making up a cycle using the State design pattern.
 */
public abstract class Cycle {
    int choice = 0;
    Scanner in = new Scanner(System.in);
    public abstract void doQuarterEvent(int quarter, TechGiant techGiant);
}
