package CodingTest.Programmers;

/*
아이디어
- 트리 (Trie)

정답 참고
- https://girawhale.tistory.com/110
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(final String[] words, final String[] queries) {
        final Trie front = new Trie();
        final Trie back = new Trie();

        for (final String word : words) {
            front.insert(word);
            back.insert(reverse(word));
        }

        return Arrays.stream(queries)
                .mapToInt(
                        query -> query.charAt(0) == '?' ?
                                back.find(reverse(query), 0) :
                                front.find(query, 0))
                .toArray();
    }

    private String reverse(final String word) {
        return new StringBuilder(word).reverse().toString();
    }

    static class Trie {
        Map<Integer, Integer> lenMap = new HashMap<>();
        Trie[] child = new Trie[26];

        void insert(final String str) {
            Trie node = this;
            final int len = str.length();
            lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

            for (final char ch : str.toCharArray()) {
                final int idx = ch - 'a';
                if (node.child[idx] == null) {
                    node.child[idx] = new Trie();
                }

                node = node.child[idx];
                node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
            }
        }

        int find(final String str, final int curIdx) {
            if (str.charAt(curIdx) == '?') {
                return lenMap.getOrDefault(str.length(), 0);
            }

            final int charIdx = str.charAt(curIdx) - 'a';
            return child[charIdx] == null ? 0 : child[charIdx].find(str, curIdx + 1);
        }
    }
}
