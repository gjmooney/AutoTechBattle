package test.java;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.players.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleManagerTest {
    GameLogic testLogic = GameLogic.getLogic();

    //Create tech giants
    TechGiant tesTg1 = new SocialMediaTechGiant("tesTg1");
    TechGiant tesTg2 = new OsTechGiant("tesTg2");


    //Create startups
    StartUp testSu1 = new RealEstateStartUp("testSu1");
    StartUp testSu2 = new HealthCareStartUp("testSu2");
    StartUp testSu3 = new FinTechStartUp("testSu3");
    StartUp testSu4 = new SocialMediaStartUp("testSu4");


    //Tech giants acquire startups


    @Before
    public void setUp() throws Exception {
        testLogic.addTechGiant(tesTg1);
        testLogic.addTechGiant(tesTg2);

        testLogic.addOwnedStartUp(testSu1);
        testLogic.addOwnedStartUp(testSu2);
        testLogic.addWildStartUp(testSu3);
        testLogic.addWildStartUp(testSu4);

        tesTg1.addStartUp(testSu1);
        tesTg2.addStartUp(testSu2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void startBattle() {
        testSu2.setCurrentHealth(1);
        StartUp winner1 = GameLogic.getLogic().getBattleManager().startBattle(testSu1, testSu2);
        assertEquals(testSu1, winner1);

        testSu2.setCurrentHealth(testSu2.getMaxHealth());
        testSu1.setCurrentHealth(1);

        StartUp winner2 = GameLogic.getLogic().getBattleManager().startBattle(testSu1, testSu2);
        assertEquals(testSu2, winner2);
    }
}