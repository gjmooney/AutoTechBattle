package main.java.siliconsim.players;

public class SocialMediaStartUp extends StartUp {

    public SocialMediaStartUp() {
        super();
        this.setName("Social Media");
        this.init();
    }

    public SocialMediaStartUp(String name) {
        super(name);
        this.init();
    }

    public void init() {
        this.setType(Type.SOCIAL_MEDIA);
        this.setAttack(50);
        this.setHealth(100);
        this.setDefense(150);
        this.setCritChance(14);
    }
}
