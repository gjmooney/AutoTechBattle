package main.java.siliconsim;

import java.util.LinkedList;
import java.util.Scanner;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public final class GameLogic {
    private static boolean gameOver;
    private static GameLogic logic;
    private static BattleManager battleManager;
    private static LinkedList<TechGiant> allTechGiants;
    private static LinkedList<StartUp> allStartUps;
    private static int quarter;
    private Cycle cycleState;
    static Scanner in = new Scanner(System.in);

    // Private constructor for Singleton pattern
    private GameLogic() {
        allTechGiants = new LinkedList<>();
        allStartUps = new LinkedList<>();
        battleManager = new BattleManager();
        cycleState = new OddQuarter();
        quarter = 0;
    }

    /**
     * Getter for logic singleton.
     * @return the GameLogic object for the current game
     */
    public static GameLogic getLogic() {
        if (logic == null) {
            logic = new GameLogic();
        }
        return logic;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(Cycle cycle) {
        this.cycleState = cycle;
    }

    public void changeQuarter() {
        quarter = (quarter + 1) % 4;
        System.out.println(quarter);
    }

    public Cycle getCycleState() {
        return cycleState;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        GameLogic.gameOver = gameOver;
    }

    public BattleManager getBattleManager() {
        return battleManager;
    }

    public LinkedList<TechGiant> getAllTechGiants() {
        return allTechGiants;
    }

    public void addTechGiant(TechGiant techGiant) {
        allTechGiants.add(techGiant);
    }

    public LinkedList<StartUp> getAllStartUps() {
        return allStartUps;
    }

    public void addStartUp(StartUp startUp) {
        allStartUps.add(startUp);
    }
}
