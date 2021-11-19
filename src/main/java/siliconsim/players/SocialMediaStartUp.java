package main.java.siliconsim.players;

public class SocialMediaStartUp extends StartUp {

    public SocialMediaStartUp() {
        super();
        this.setName("Social Media");
        this.setType(Type.SOCIAL_MEDIA);
        this.setAttack(50);
        this.setHealth(100);
        this.setDefense(150);
        this.setCritChance(14);
    }

    public SocialMediaStartUp(String name) {
        super(name);
        this.setType(Type.SOCIAL_MEDIA);
        this.setAttack(50);
        this.setHealth(100);
        this.setDefense(150);
        this.setCritChance(14);
    }
}
