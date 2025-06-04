import java.util.*;

public class Main {
    public static void main(String[] args) {
        FishEntry f1 = new FishEntry(1, "Nemo", FishType.SALTWATER, false);
        FishEntry f2 = new FishEntry(2, "Goldie", FishType.FRESHWATER, false);
        FishEntry f3 = new FishEntry(3, "Sharky", FishType.SALTWATER, true);
        FishEntry f4 = new FishEntry(2, "Goldie", FishType.FRESHWATER, false); // duplicate by id
        FishEntry f5 = new FishEntry(4, "Piranha", FishType.FRESHWATER, true);

        List<FishEntry> fishList = new ArrayList<>();
        fishList.add(f1);
        fishList.add(f2);
        fishList.add(f3);
        fishList.add(f4);
        fishList.add(f5);

        System.out.println("1. Unordered List:");
        fishList.forEach(System.out::println);

        Set<FishEntry> uniqueFish = new HashSet<>(fishList);
        System.out.println("\n2. HashSet (unique by id):");
        uniqueFish.forEach(System.out::println);

        Collections.sort(fishList);
        System.out.println("\n3. Sorted List (by name):");
        fishList.forEach(System.out::println);

        Set<FishEntry> sortedSet = new TreeSet<>(fishList);
        System.out.println("\n4. TreeSet (unique and sorted):");
        sortedSet.forEach(System.out::println);

        Map<Integer, FishEntry> fishMap = new TreeMap<>();
        for (FishEntry f : fishList) {
            fishMap.put(f.getId(), f);
        }
        System.out.println("\n5. TreeMap<id, Fish>:");
        fishMap.forEach((id, fish) -> System.out.println("id=" + id + " → " + fish));

        LinkedList<FishEntry> linkedFish = new LinkedList<>(fishList);
        System.out.println("\n6. LinkedList:");
        linkedFish.forEach(System.out::println);

        Queue<FishEntry> fishQueue = new LinkedList<>(fishList);
        System.out.println("\n7. Queue (FIFO):");
        while (!fishQueue.isEmpty()) {
            System.out.println(fishQueue.poll());
        }

        PriorityQueue<FishEntry> priorityFish = new PriorityQueue<>(fishList);
        System.out.println("\n8. PriorityQueue (by name):");
        while (!priorityFish.isEmpty()) {
            System.out.println(priorityFish.poll());
        }
    }
}
