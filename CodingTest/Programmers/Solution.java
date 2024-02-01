package CodingTest.Programmers;

/*
아이디어 - DFS / BFS
 */

import java.util.HashSet;
import java.util.Set;

class Solution {

    private int answer;
    private String gTarget;

    public int solution(final String begin, final String target, final String[] words) {
        answer = Integer.MAX_VALUE;
        gTarget = target;

        final Set<String> isVisited = new HashSet<>();
        dfs(words, begin, 0, isVisited);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(final String[] words, final String curWord, final int count, final Set<String> isVisited) {
        if (curWord.equals(gTarget)) {
            answer = Math.min(count, answer);
            return;
        }

        for (final String word : words) {
            if (!isDiffOneChar(curWord, word) || isVisited.contains(word)) continue;

            isVisited.add(word);
            dfs(words, word, count + 1, isVisited);
            isVisited.remove(word);
        }
    }

    private boolean isDiffOneChar(final String curWord, final String nextWord) {
        if (curWord.length() != nextWord.length()) {
            return false;
        }

        final int len = curWord.length();

        int diffCount = 0;
        for (int i = 0; i < len; i++) {
            if (curWord.charAt(i) != nextWord.charAt(i)) {
                diffCount++;
            }

            if (diffCount > 1) {
                return false;
            }
        }

        return true;
    }
}
