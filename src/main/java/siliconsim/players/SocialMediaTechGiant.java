package main.java.siliconsim.players;

public class SocialMediaTechGiant extends TechGiant {

    /**
     * Basic constructor for social media tech giants.
     */
    public SocialMediaTechGiant() {
        super();
        this.setName("Social Media Tech Giant");
        init();
    }

    public SocialMediaTechGiant(String name) {
        super(name);
        init();
    }

    public void init() {
        this.setType(Type.SOCIAL_MEDIA);
    }

    @Override
    public void rally() {

    }
}
