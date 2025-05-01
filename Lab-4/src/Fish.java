public class Fish {
    private final String name;
    private final Heart heart;

    public Fish(String name) {
        this.name = name;
        this.heart = new Heart();
    }

    class Heart {
        void beat() {
            System.out.println(name + "'s heart is beating.");
        }
    }

    public static class SpeciesInfo {
        public static void display(String species) {
            System.out.println("Species Info: " + species + " is a tropical fish.");
        }
    }

    public void showSpeciesInfo() {
        SpeciesInfo.display(name);
    }

    public void pumpHeart() {
        heart.beat();
    }

    public String getName() {
        return name;
    }

    public void clean() {
        class Cleaner {
            void cleanFish() {
                System.out.println("Cleaning " + name);
            }
        }
        Cleaner cleaner = new Cleaner();
        cleaner.cleanFish();
    }
}
