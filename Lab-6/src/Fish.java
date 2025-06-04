public abstract class Fish implements Swimmable {
    protected String name;
    protected FishType type;
    protected boolean isPredator;
    protected Food food;

    public Fish(String name, FishType type, boolean isPredator) {
        this.name = name;
        this.type = type;
        this.isPredator = isPredator;
        this.food = new Food("Plankton");
    }

    public abstract void swim();

    public void info() {
        System.out.println(name + " is a " + (isPredator ? "predator" : "peaceful") + " " + type + " fish.");
    }

    public void interactWithOtherFish(Fish other) {
        System.out.println(this.name + " interacts with " + other.name);
    }

    public class Organ {
        private String name;

        public Organ(String name) {
            this.name = name;
        }

        public void function() {
            System.out.println(name + " is functioning.");
        }
    }
}