public class MarineBiologist {
    private final String name;

    public MarineBiologist(String name) {
        this.name = name;
    }

    public void observe(Fish fish) {
        System.out.println(name + " is observing the " + fish.getName() + ".");
    }
}
