package players.java;

import java.util.LinkedList;

public class OsTechGiant extends TechGiant{

    public OsTechGiant() {
        this.name = "Social Media";
        this.type = Type.OPERATING_SYSTEM;
        this.startUps = new LinkedList<>();
    }

    public OsTechGiant(String name) {
        this.name = name;
        this.type = Type.OPERATING_SYSTEM;
        this.startUps = new LinkedList<>();
    }

    @Override
    public void rally() {

    }
}
