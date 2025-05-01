import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";

        try {
            String content = Files.readString(Paths.get(filePath));

            Pattern pattern = Pattern.compile("[\"«](.*?)[\"»]");
            Matcher matcher = pattern.matcher(content);

            List<String> quotes = new ArrayList<>();
            while (matcher.find()) {
                quotes.add(matcher.group(1));
            }

            if (quotes.isEmpty()) {
                System.out.println("Цитат не знайдено.");
            } else {
                System.out.println("Знайдені цитати:");
                for (String quote : quotes) {
                    System.out.println("- " + quote);
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}
