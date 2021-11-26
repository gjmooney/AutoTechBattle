package main.java.siliconsim;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import main.java.siliconsim.players.TechGiant;

/**
 * Represents the four quarters making up a cycle using the State design pattern.
 */
public abstract class Cycle {
    int choice = 0;

    //Scanner in = new Scanner(System.in, StandardCharsets.UTF_8.name());

    public abstract void doQuarterEvent(int quarter, TechGiant techGiant);
}
