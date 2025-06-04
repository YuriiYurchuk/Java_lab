public class Piranha extends Fish {
    public Piranha(String name) {
        super(name, FishType.FRESHWATER, true);
    }

    @Override
    public void swim() {
        System.out.println(name + " the piranha swims aggressively.");
    }
}