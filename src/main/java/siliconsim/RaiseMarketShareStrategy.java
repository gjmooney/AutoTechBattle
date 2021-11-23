package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class RaiseMarketShareStrategy implements OddQuarterStrategy {
    @Override
    public void doEvent(TechGiant techGiant) {
        int oldMarketShare;
        for (StartUp su : techGiant.getStartUps()) {
            oldMarketShare = su.getDefense();
            su.setDefense((int) Math.ceil(su.getDefense() * 1.2));
            System.out.println(su.getName() + "'s Market Share increased from "
                    + oldMarketShare + " to " + su.getDefense());
        }
    }
}
