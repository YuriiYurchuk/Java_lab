public class Shark extends Fish {
    public Shark(String name) {
        super(name, FishType.SALTWATER, true);
    }

    @Override
    public void swim() {
        System.out.println(name + " swiftly swims in the ocean.");
    }
}
