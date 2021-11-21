package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

import java.util.LinkedList;

public class RaiseMarketShareStrategy implements OddQuarterStrategy{
    @Override
    public void doEvent(LinkedList<StartUp> startUps) {
        int oldMarketShare;
        for (StartUp su : startUps) {
            oldMarketShare = su.getDefense();
            su.setDefense((int) Math.ceil(su.getDefense() * 1.2));
            System.out.println(su.getName() + "'s Market Share increased from "
                    + oldMarketShare + " to " + su.getDefense());
        }
    }
}
