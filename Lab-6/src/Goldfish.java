public class Goldfish extends Fish {
    public Goldfish(String name) {
        super(name, FishType.FRESHWATER, false);
    }

    @Override
    public void swim() {
        System.out.println(name + " the goldfish swims gently.");
    }
}