package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}

class Solution {
    public boolean arrayStringsAreEqual(final String[] word1, final String[] word2) {
        String answer1 = "";
        String answer2 = "";

        for (int i = 0; i < word1.length; i++) {
            answer1 += word1[i];
        }

        for (int i = 0; i < word2.length; i++) {
            answer2 += word2[i];
        }

        return answer1.equals(answer2);
    }
}
