import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>(Arrays.asList(
                "привіт", "світ", "java", "програма", "слово", "перевірка"
        ));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть речення:");
        String input = scanner.nextLine().toLowerCase();

        String[] words = input.replaceAll("[^а-яА-Яa-zA-Z ]", "").split("\\s+");

        boolean hasMistakes = false;
        System.out.println("Результат перевірки:");

        for (String word : words) {
            if (!dictionary.contains(word)) {
                System.out.println("Можлива помилка: " + word);
                hasMistakes = true;
            }
        }

        if (!hasMistakes) {
            System.out.println("Орфографічних помилок не знайдено.");
        }
    }
}
