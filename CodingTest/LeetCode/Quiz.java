package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }
}

class Solution {
    public int countCharacters(final String[] words, final String chars) {
        final int[] charsCount = new int[26];
        extractCharArray(charsCount, chars);

        int answer = 0;

        for (final String tempWord : words) {
            boolean isEnable = true;

            final int[] tempWordCount = new int[26];
            extractCharArray(tempWordCount, tempWord);
            for (int j = 0; j < charsCount.length; j++) {
                if (charsCount[j] < tempWordCount[j]) {
                    isEnable = false;
                    break;
                }
            }

            if (isEnable) {
                answer += tempWord.length();
            }
        }

        return answer;
    }

    private void extractCharArray(final int[] charsArray, final String string) {
        for (int i = 0; i < string.length(); i++) {
            charsArray[string.charAt(i) - 'a']++;
        }
    }
}
