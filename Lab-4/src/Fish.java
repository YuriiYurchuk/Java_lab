public abstract class Fish implements Swimmable {
    public String name;
    public FishType type;
    public boolean isPredator;
    public Organ gills;
    public Food food;

    public Fish(String name, FishType type, boolean isPredator) {
        this.name = name;
        this.type = type;
        this.isPredator = isPredator;
        this.gills = new Organ("Gills");
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void info() {
        System.out.println("\n=== " + name + " ===");
        System.out.println("Type: " + type);
        System.out.println("Predator: " + (isPredator ? "Yes" : "No"));
        System.out.println("Food: " + (food != null ? food.type : "none"));
    }

    public void interactWithOtherFish(Fish other) {
        if (this == other) return;
        System.out.print(name + " meets " + other.name + " → ");
        if (this.isPredator && !other.isPredator) {
            System.out.println("might attack!");
        } else {
            System.out.println("swim peacefully.");
        }
    }

    // Inner class
    public class Organ {
        String type;

        public Organ(String type) {
            this.type = type;
        }

        public void function() {
            System.out.println(name + " uses " + type);
        }
    }
}
