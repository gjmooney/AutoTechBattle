package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class RaiseMarketShareStrategy implements OddQuarterStrategy {
    @Override
    public void doEvent(TechGiant techGiant) {
        int oldMarketShare;
        for (StartUp su : techGiant.getStartUps()) {
            oldMarketShare = su.getMarketShare();
            su.setMarketShare((int) Math.ceil(su.getMarketShare() * 1.2));
            System.out.println(su.getName() + "'s Market Share increased from "
                    + oldMarketShare + " to " + su.getMarketShare());
        }
    }
}
