package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public String[] solution(final String[] strings, final int n) {
        final List<Word> list = new ArrayList<>();

        for (final String string : strings) {
            list.add(new Word(string, string.charAt(n)));
        }

        list.sort(Comparator.comparing(Word::getN).thenComparing(Word::getWord));

        return list.stream()
                .map(Word::getWord)
                .toArray(String[]::new);
    }

    static class Word {
        private final String word;
        private final char n;

        public Word(final String word, final char n) {
            this.word = word;
            this.n = n;
        }

        public String getWord() {
            return this.word;
        }

        public char getN() {
            return this.n;
        }
    }
}
