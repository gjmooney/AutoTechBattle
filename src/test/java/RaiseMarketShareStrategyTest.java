package test.java;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.RaiseMarketShareStrategy;
import main.java.siliconsim.players.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaiseMarketShareStrategyTest {

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
    public void doEvent() {
        RaiseMarketShareStrategy raiseMarketShareStrategy = new RaiseMarketShareStrategy();
        testSu1.setDefense(100);
        testSu3.setDefense(100);
        raiseMarketShareStrategy.doEvent(tesTg1);
        assertEquals(120, testSu1.getDefense());
        assertEquals(120, testSu3.getDefense());
    }
}