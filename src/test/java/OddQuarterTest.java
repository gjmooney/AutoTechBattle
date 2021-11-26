package test.java;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.OddQuarter;
import main.java.siliconsim.players.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OddQuarterTest {

    GameLogic testLogic = GameLogic.getLogic();

    //Create tech giants
    TechGiant tesTg1 = new SocialMediaTechGiant("tesTg1");
    TechGiant tesTg2 = new OsTechGiant("tesTg2");

    //Create startups
    StartUp testSu1 = new RealEstateStartUp("testSu1");
    StartUp testSu2 = new HealthCareStartUp("testSu2");
    StartUp testSu3 = new FinTechStartUp("testSu3");
    StartUp testSu4 = new SocialMediaStartUp("testSu4");

    @Before
    public void setUp() throws Exception {
        testLogic.addTechGiant(tesTg1);
        testLogic.addTechGiant(tesTg2);

        testLogic.addOwnedStartUp(testSu1);
        testLogic.addOwnedStartUp(testSu2);
        testLogic.addOwnedStartUp(testSu3);
        testLogic.addWildStartUp(testSu4);

        tesTg1.addStartUp(testSu1);
        tesTg1.addStartUp(testSu3);
        tesTg2.addStartUp(testSu2);
    }

    @Test
    public void doQuarterEvent() {
        testLogic.setCycleState(new OddQuarter());
        // set health and check that
        testSu1.setMaxHealth(120);
        testSu1.setCurrentHealth(100);
        testSu3.setMaxHealth(120);
        testSu3.setCurrentHealth(100);
        testLogic.getCycleState().doQuarterEvent(testLogic.getQuarter(), tesTg1);

        assertEquals(144, testSu1.getCurrentHealth());
        assertEquals(144, testSu3.getCurrentHealth());
    }
}