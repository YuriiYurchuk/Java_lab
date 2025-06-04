public class Main {
    public static void main(String[] args) {
        Food shrimp = new Food("Shrimp");
        Food flakes = new Food("Fish Flakes");

        Fish[] fishes = {
                new Shark("White Shark"),
                new Goldfish("Goldie"),
                new Clownfish("Nemo"),
                new Piranha("Red Piranha")
        };

        fishes[0].setFood(shrimp);
        fishes[1].setFood(flakes);
        fishes[2].setFood(shrimp);
        fishes[3].setFood(flakes);

        Pond pond = new Pond();
        pond.observeFish(fishes[1]);

        for (Fish fish : fishes) {
            fish.info();
            fish.swim();
            fish.gills.function();
        }

        System.out.println("\n== Interactions ==");
        for (int i = 0; i < fishes.length; i++) {
            for (int j = 0; j < fishes.length; j++) {
                fishes[i].interactWithOtherFish(fishes[j]);
            }
        }

        AquariumUtils.WaterAnalyzer.analyze();
        simulate(fishes[0]);
    }

    static void simulate(Fish fish) {
        class Interaction {
            void feed() {
                System.out.println("Feeding " + fish.name + " with " + fish.food.type);
            }
        }
        Interaction interaction = new Interaction();
        interaction.feed();
    }
}
