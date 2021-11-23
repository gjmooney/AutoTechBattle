package main.java.siliconsim.players;

import java.util.LinkedList;

public class SocialMediaTechGiant extends TechGiant {

    public SocialMediaTechGiant() {
        this.setName("Social Media Tech Giant");
    }

    public SocialMediaTechGiant(String name) {
        super(name);
    }

    public void init() {
        this.setType(Type.SOCIAL_MEDIA);
    }

    @Override
    public void rally() {

    }
}
