package Homework;

import java.util.*;

public class JavaCodeQuiz1 {
    public static void main(String[] args) {


        // 1) Java Program to Find the First Non-repeated Character in a String

        String a = "installation";
        String sum = "";

        for (int i = 0; i < a.length(); i++) {
            String lttr = a.substring(i, i + 1);
            if (a.indexOf(lttr) == a.lastIndexOf(lttr)) {
                sum = sum + lttr;
                break;
            }
        }
        System.out.println("Q1) First non-repeat character: " + sum);
        System.out.println();


        // 2)  Java Program to Check Palindrome String

        String word = "Hakan";
        String bosluk = "";

        for (Integer i = word.length() - 1; i > -1; i--) {
            String letter = word.substring(i, i + 1);
            bosluk = bosluk + letter;
        }
        if (word.equals(bosluk)) {
            System.out.println("Q2) " + word + " " + "is palindrome string");
        } else {
            System.out.println("Q2) " + word + " " + "is not palindrome string");
        }
        System.out.println();

        // 3)  Java Program to Find Duplicate Characters in a String

        String word2 = "Programming";

        word2 = word2.toLowerCase().replaceAll("\\p{Punct}", "");


        Map<Character, Integer> charFrequency = new HashMap<>();

        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);

            if (ch != ' ') {

                if (charFrequency.containsKey(ch)) {
                    charFrequency.put(ch, charFrequency.get(ch) + 1);
                } else {

                    charFrequency.put(ch, 1);
                }
            }
        }

        System.out.println("Q3) Duplicate letters:");
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
            }
        }

        System.out.println();

        // 4)  Java Program to Find Duplicate Words in a String

        String str = "Java is a programming language. Java is widely used in industry.";
        String[] words = str.toLowerCase().replaceAll("\\p{Punct}", "").split(" ");
        //System.out.println(Arrays.toString(words)); // [java, is, a, programming, language, java, is, widely, used, in, industry]

        Map<String, Integer> wordFrequence = new HashMap<>();

        for (String w : words) {
            if (wordFrequence.containsKey(w)) {
                wordFrequence.put(w, wordFrequence.get(w) + 1);
            } else {
                wordFrequence.put(w, 1);
            }
        }
        System.out.println("Q4) Duplicate words:");
        for (Map.Entry<String, Integer> entry : wordFrequence.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " " + "times");
            }
        }

        System.out.println();

        // 5) Java Program to Find All the Permutations of a String

        String input = "XYZ";
        Set<String> permutations = findAllPermutations(input);
        System.out.println("Q5) All permutations of " + input + ": ");
        for (String permutation : permutations) {
            System.out.print(permutation + ", " );

        }

    }// main disi

    public static Set<String> findAllPermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char initial = str.charAt(0);
        String remaining = str.substring(1);
        Set<String> words = findAllPermutations(remaining);

        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + initial + suffix);
            }
        }

        return permutations;
    }

}

