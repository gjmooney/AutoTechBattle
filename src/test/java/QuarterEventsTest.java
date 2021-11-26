package test.java;

import static org.junit.Assert.assertEquals;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.QuarterEvents;
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

public class QuarterEventsTest {
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
    public void taxCuts() {
        testSu1.setMaxRevenue(100);
        testSu2.setMaxRevenue(100);
        testSu3.setMaxRevenue(100);
        testSu4.setMaxRevenue(100);
        QuarterEvents.taxCuts();
        assertEquals(120, testSu1.getMaxRevenue());
        assertEquals(120, testSu2.getMaxRevenue());
        assertEquals(120, testSu3.getMaxRevenue());
        assertEquals(120, testSu4.getMaxRevenue());
    }

    @Test
    public void financialCrisis() {
        testSu1.setNetIncome(100);
        testSu1.setMarketShare(100);
        testSu2.setNetIncome(100);
        testSu2.setMarketShare(100);
        testSu3.setNetIncome(100);
        testSu3.setMarketShare(100);
        testSu4.setNetIncome(100);
        testSu4.setMarketShare(100);

        QuarterEvents.financialCrisis();

        assertEquals(80, testSu1.getMarketShare());
        assertEquals(80, testSu1.getNetIncome());
        assertEquals(80, testSu2.getMarketShare());
        assertEquals(80, testSu2.getNetIncome());
        assertEquals(100, testSu3.getMarketShare());
        assertEquals(100, testSu3.getNetIncome());
        assertEquals(80, testSu4.getMarketShare());
        assertEquals(80, testSu4.getNetIncome());
    }

    @Test
    public void monopolyBusting() {
        testSu1.setMaxRevenue(100);
        testSu2.setMaxRevenue(100);
        testSu1.setMarketShare(400);
        testSu2.setMarketShare(400);

        testSu3.setMaxRevenue(100);
        testSu4.setMaxRevenue(100);
        QuarterEvents.monopolyBusting();
        assertEquals(80, testSu1.getMaxRevenue());
        assertEquals(80, testSu2.getMaxRevenue());
        assertEquals(120, testSu3.getMaxRevenue());
        assertEquals(120, testSu4.getMaxRevenue());
    }

    @Test
    public void lobbying() {
        testSu1.setMarketShare(100);
        testSu2.setMarketShare(100);
        testSu3.setMarketShare(100);
        testSu4.setMarketShare(100);

        QuarterEvents.lobbying();

        assertEquals(120, testSu1.getMarketShare());
        assertEquals(120, testSu2.getMarketShare());
        assertEquals(120, testSu3.getMarketShare());
        assertEquals(120, testSu4.getMarketShare());
    }
}