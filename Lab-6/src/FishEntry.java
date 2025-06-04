import java.util.Objects;

public class FishEntry extends Fish implements Comparable<FishEntry> {
    private int id;

    public FishEntry(int id, String name, FishType type, boolean isPredator) {
        super(name, type, isPredator);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void swim() {
        System.out.println(name + " (id=" + id + ") swims.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FishEntry)) return false;
        FishEntry that = (FishEntry) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(FishEntry o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " [id=" + id + "]";
    }
}