package main.java.siliconsim;

import java.util.LinkedList;
import java.util.Random;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public final class GameLogic {
    private static boolean gameOver;
    private static GameLogic logic;
    private static BattleManager battleManager;
    private static LinkedList<TechGiant> allTechGiants;
    private static LinkedList<StartUp> ownedStartUps;
    private static LinkedList<StartUp> wildStartUps;
    private static int quarter;
    private static Cycle cycleState;
    private static boolean hasEvolved;
    private static Random random;

    // Private constructor for Singleton pattern
    private GameLogic() {
        setAllTechGiants(new LinkedList<>());
        setOwnedStartUps(new LinkedList<>());
        setWildStartUps(new LinkedList<>());
        setBattleManager(new BattleManager());
        setCycleState(new OddQuarter());
        setQuarter(0);
        setRandom(new Random());
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

    /**
     * Generate an int to mimic a players choice.
     * @param max Top end of range (exclusive)
     * @param min Lower end of range (inclusive)
     * @return Int between min (inclusive) and max (exclusive)
     */
    public int generateChoice(int max, int min) {
        System.out.println((int) (Math.random() * (max - min)) + min);
        return (int) (Math.random() * (max - min)) + min;
    }

    public Random getRandom() {
        return random;
    }

    public boolean isHasEvolved() {
        return hasEvolved;
    }

    public static void setHasEvolved(boolean evolved) {
        hasEvolved = evolved;
    }

    public int getQuarter() {
        return quarter;
    }

    public static void setQuarter(int newQuarter) {
        quarter = newQuarter;
    }

    public void changeQuarter() {
        setQuarter((quarter + 1) % 4);
        System.out.println(quarter);
    }

    public static void setCycleState(Cycle cycle) {
        cycleState = cycle;
    }

    public Cycle getCycleState() {
        return cycleState;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public static void setGameOver(boolean isGameOver) {
        gameOver = isGameOver;
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

    public LinkedList<StartUp> getAllOwnedStartUps() {
        return ownedStartUps;
    }

    public void addOwnedStartUp(StartUp startUp) {
        ownedStartUps.add(startUp);
    }

    public void removeOwnedStartUp(StartUp startUp) {
        ownedStartUps.remove(startUp);
    }

    public LinkedList<StartUp> getWildStartUps() {
        return wildStartUps;
    }

    public void addWildStartUp(StartUp startUp) {
        wildStartUps.add(startUp);
    }

    public void removeWildStartUp(StartUp startUp) {
        wildStartUps.remove(startUp);
    }

    public static void setLogic(GameLogic logic) {
        GameLogic.logic = logic;
    }

    public static void setBattleManager(BattleManager battleManager) {
        GameLogic.battleManager = battleManager;
    }

    public static void setAllTechGiants(LinkedList<TechGiant> allTechGiants) {
        GameLogic.allTechGiants = allTechGiants;
    }

    public static void setOwnedStartUps(LinkedList<StartUp> ownedStartUps) {
        GameLogic.ownedStartUps = ownedStartUps;
    }

    public static void setWildStartUps(LinkedList<StartUp> wildStartUps) {
        GameLogic.wildStartUps = wildStartUps;
    }

    public static void setRandom(Random random) {
        GameLogic.random = random;
    }

    /**
     * Get a list of all start-ups in the game.
     * @return List of all start-ups
     */
    public LinkedList<StartUp> getAllStartUps() {
        LinkedList<StartUp> list = new LinkedList<>();
        list.addAll(getAllOwnedStartUps());
        list.addAll(getWildStartUps());
        return list;
    }
}
