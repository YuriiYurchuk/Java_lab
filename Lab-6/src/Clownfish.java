public class Clownfish extends Fish {
    public Clownfish(String name) {
        super(name, FishType.SALTWATER, false);
    }

    @Override
    public void swim() {
        System.out.println(name + " the clownfish darts around playfully.");
    }
}