package main.java.siliconsim.players;

public class SocialMediaStartUp extends StartUp {

    /**
     * Basic constructor for social media start-ups.
     */
    public SocialMediaStartUp() {
        super();
        this.setName("Social Media");
        this.init();
    }

    public SocialMediaStartUp(String name) {
        super(name);
        this.init();
    }

    /**
     * Initializer for social media start-ups.
     * Sets type and initial stats
     */
    public void init() {
        this.setType(Type.SOCIAL_MEDIA);
        this.setAttack(50);
        this.setMaxHealth(100);
        this.setDefense(150);
        this.setCritChance(14);
    }
}
