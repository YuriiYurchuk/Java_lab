import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private final List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {
        fishList.add(fish);
        System.out.println(fish.getName() + " added to the aquarium.");
    }

    public void showAllFish() {
        System.out.println("Fish in the aquarium:");
        for (Fish fish : fishList) {
            System.out.println("- " + fish.getName());
        }
    }
}
