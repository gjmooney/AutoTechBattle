package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

import java.util.LinkedList;
import java.util.Scanner;

public final class GameLogic {
    private static GameLogic logic;
    private static BattleManager battleManager;
    private static LinkedList<TechGiant> allTechGiants;
    private static LinkedList<StartUp> allStartUps;
    static Scanner in = new Scanner(System.in);

    // Private constructor for Singleton pattern
    private GameLogic() {
        allTechGiants = new LinkedList<>();
        allStartUps = new LinkedList<>();
        battleManager = new BattleManager();
    }

    /**
     * Getter for logic singleton
     * @return the GameLogic object for the current game
     */
    public static GameLogic getLogic() {
        if (logic == null) {
            logic = new GameLogic();
        }
        return logic;
    }

    public BattleManager getBattleManager() {
        return battleManager;
    }

    public static LinkedList<TechGiant> getAllTechGiants() {
        return allTechGiants;
    }

    public void addTechGiant(TechGiant techGiant) {
        allTechGiants.add(techGiant);
    }

    public static LinkedList<StartUp> getAllStartUps() {
        return allStartUps;
    }

    public void addStartUp(StartUp startUp) {
        allStartUps.add(startUp);
    }
}