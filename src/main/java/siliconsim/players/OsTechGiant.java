package main.java.siliconsim.players;

public class OsTechGiant extends TechGiant {

    /**
     * Basic constructor for Operating system tech giants.
     */
    public OsTechGiant() {
        super();
        this.setName("Social Media Tech Giant");
        init();
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
