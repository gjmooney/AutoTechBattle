package main.java.siliconsim.players;

import java.util.LinkedList;

public class OsTechGiant extends TechGiant {

    public OsTechGiant() {
        super();
        this.setName("Social Media Tech Giant");
        init();;
    }

    public OsTechGiant(String name) {
        super(name);
        init();
    }

    public void init() {
        this.setType(Type.OPERATING_SYSTEM);
    }

    @Override
    public void rally() {

    }
}
