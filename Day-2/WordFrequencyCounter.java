package day2;


import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a text:");
        String text = scanner.nextLine();

        countWordFrequency(text);

        scanner.close();
    }

    public static void countWordFrequency(String text) {
        text = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        String[] words = text.split("\\s+");

        HashMap<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());

        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("Word Frequencies (Highest to Lowest):");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
