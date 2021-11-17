package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;

public class SocialMediaStartUp extends StartUp{

    public SocialMediaStartUp() {
        super();
        this.setName("Social Media");
        this.setType(Type.SOCIAL_MEDIA);
        this.setNetIncome(50);
        this.setRevenue(100);
        this.setMarketShare(150);
    }

    public SocialMediaStartUp(String name) {
        super();
        this.setType(Type.SOCIAL_MEDIA);
        this.setNetIncome(50);
        this.setRevenue(100);
        this.setMarketShare(150);
    }
}
