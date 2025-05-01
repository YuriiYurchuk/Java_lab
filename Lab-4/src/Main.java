public class Main {
    public static void main(String[] args) {
        Fish clownfish = new Fish("Clownfish");
        clownfish.showSpeciesInfo();
        clownfish.pumpHeart();

        Fish goldfish = new Fish("Goldfish");
        goldfish.showSpeciesInfo();
        goldfish.pumpHeart();

        Aquarium aquarium = new Aquarium();
        aquarium.addFish(clownfish);
        aquarium.addFish(goldfish);

        aquarium.showAllFish();

        MarineBiologist biologist = new MarineBiologist("Dr. Reef");
        biologist.observe(clownfish);
        biologist.observe(goldfish);

        clownfish.clean();
        goldfish.clean();
    }
}
