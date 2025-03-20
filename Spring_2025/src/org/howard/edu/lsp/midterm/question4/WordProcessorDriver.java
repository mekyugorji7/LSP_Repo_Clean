package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

class WordProcessor {
    private String sentence;

    /**
     * Constructor to initialize the WordProcessor with a sentence.
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds and returns all longest words in the sentence.
     * @return A list of longest words in order of appearance.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list if input is empty or contains no words
        }

        String[] words = sentence.split("\\s+"); // Handle multiple whitespaces
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word);
            }
        }
        return longestWords;
    }
}

/**
 * The WordProcessorDriver class tests the functionality of the WordProcessor class.
 */
public class WordProcessorDriver {
    /**
     * Main method to run test cases for WordProcessor.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        
        // Test case 1: Sentence with a single longest word
        WordProcessor wp4 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 1 - Longest words: " + longestWords4);  

        // Test case 2: Sentence with multiple occurrences of the same longest word and length
        WordProcessor wp2 = new WordProcessor("Java is a powerful powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + longestWords2);  

        // Test case 5: Sentence with single character words
        WordProcessor wp5 = new WordProcessor("A B C D E");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + longestWords5);  

        // Test case 6: Empty string input
        WordProcessor wp6 = new WordProcessor("");
        List<String> longestWords6 = wp6.findLongestWords();
        System.out.println("Test 6 - Longest words: " + longestWords6);  
    }
}

