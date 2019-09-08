package com.thoughtworks.collection;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return this.array.stream().map(it -> it * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(it -> letters[it - 1]).collect(Collectors.toList());
    }

    private String toLetters(int number) {
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        StringBuilder letter = new StringBuilder();
        while (number != 0) {
            int rest = number % 26;
            number /= 26;
            if (rest == 0) {
                letter.insert(0, 'z');
                number -= 1;
            } else {
                letter.insert(0, alphabet.charAt(rest));
            }
        }
        return letter.toString();
    }

    public List<String> mapLetters() {
        return array.stream().map(this::toLetters).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
