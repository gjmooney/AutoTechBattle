package players.java;

import attacks.java.AttackStrategy;

public class SocialMediaStartUp extends StartUp{

    public SocialMediaStartUp() {
        this.name = "Real Estate";
        this.type = Type.SOCIAL_MEDIA;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 100;
        this.marketShare = 150;
    }

    public SocialMediaStartUp(String name) {
        this.name = name;
        this.type = Type.SOCIAL_MEDIA;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 100;
        this.marketShare = 150;
    }
}
