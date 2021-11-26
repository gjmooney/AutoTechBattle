package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import main.java.siliconsim.EvenQuarter;
import main.java.siliconsim.GameLogic;
import main.java.siliconsim.players.FinTechStartUp;
import main.java.siliconsim.players.HealthCareStartUp;
import main.java.siliconsim.players.OsTechGiant;
import main.java.siliconsim.players.RealEstateStartUp;
import main.java.siliconsim.players.SocialMediaStartUp;
import main.java.siliconsim.players.SocialMediaTechGiant;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EvenQuarterTest {
    //Create tech giants
    TechGiant tesTg1 = new SocialMediaTechGiant("tesTg1");
    TechGiant tesTg2 = new OsTechGiant("tesTg2");

    //Create startups
    StartUp testSu1 = new RealEstateStartUp("testSu1");
    StartUp testSu2 = new HealthCareStartUp("testSu2");
    StartUp testSu3 = new FinTechStartUp("testSu3");
    StartUp testSu4 = new SocialMediaStartUp("testSu4");

    /**
     * Add tech giants and start-ups to main list.
     */
    @Before
    public void setUp() {
        GameLogic.getLogic();
        GameLogic.getLogic().addTechGiant(tesTg1);
        GameLogic.getLogic().addTechGiant(tesTg2);

        GameLogic.getLogic().addOwnedStartUp(testSu1);
        GameLogic.getLogic().addOwnedStartUp(testSu2);
        GameLogic.getLogic().addOwnedStartUp(testSu3);
        GameLogic.getLogic().addOwnedStartUp(testSu4);

        tesTg1.addStartUp(testSu1);
        tesTg2.addStartUp(testSu2);
        tesTg1.addStartUp(testSu3);
        tesTg2.addStartUp(testSu4);
    }

    /**
     * Reset tech giant and start up lists.
     */
    @After
    public void tearDown() {
        GameLogic.getLogic().setAllTechGiants(null);
        GameLogic.getLogic().setOwnedStartUps(null);

        tesTg1.removeStartUp(testSu1);
        tesTg2.removeStartUp(testSu2);
        tesTg1.removeStartUp(testSu3);
        tesTg2.removeStartUp(testSu4);
        GameLogic.getLogic().setLogic(null);
    }

    @Test
    public void doQuarterEventOne() {
        GameLogic.getLogic().setCycleState(new EvenQuarter());

        testSu1.setNetIncome(100);
        testSu1.setMarketShare(100);
        testSu2.setNetIncome(100);
        testSu2.setMarketShare(100);
        testSu3.setNetIncome(100);
        testSu3.setMarketShare(100);
        testSu4.setNetIncome(100);
        testSu4.setMarketShare(100);

        GameLogic.getLogic().getCycleState().doQuarterEvent(1, tesTg1);

        assertEquals(80, testSu1.getMarketShare());
        assertEquals(80, testSu1.getNetIncome());
        assertEquals(80, testSu2.getMarketShare());
        assertEquals(80, testSu2.getNetIncome());
        assertEquals(100, testSu3.getMarketShare());
        assertEquals(100, testSu3.getNetIncome());
        assertEquals(80, testSu4.getMarketShare());
        assertEquals(80, testSu4.getNetIncome());
        assertFalse(tesTg1.isCatchWildStartUp());
    }

    @Test
    public void doQuarterEventThree() {
        GameLogic.getLogic().setCycleState(new EvenQuarter());

        testSu1.setMarketShare(100);
        testSu2.setMarketShare(100);
        testSu3.setMarketShare(100);
        testSu4.setMarketShare(100);

        GameLogic.getLogic().getCycleState().doQuarterEvent(3, tesTg1);

        assertEquals(120, testSu1.getMarketShare());
        assertEquals(120, testSu2.getMarketShare());
        assertEquals(120, testSu3.getMarketShare());
        assertEquals(120, testSu4.getMarketShare());
        assertFalse(tesTg1.isCatchWildStartUp());

    }
}