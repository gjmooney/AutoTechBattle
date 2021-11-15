package players.java;

import java.util.LinkedList;

public class SocialMediaTechGiant extends TechGiant{

    public SocialMediaTechGiant() {
        this.name = "Social Media";
        this.type = Type.SOCIAL_MEDIA;
        this.startUps = new LinkedList<>();
    }

    public SocialMediaTechGiant(String name) {
        this.name = name;
        this.type = Type.SOCIAL_MEDIA;
        this.startUps = new LinkedList<>();
    }

    @Override
    public void rally() {

    }
}
