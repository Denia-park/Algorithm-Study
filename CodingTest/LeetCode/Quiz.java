package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.characterReplacement("ABAB", 2) == 4);
        System.out.println(solution.characterReplacement("AABABBA", 1) == 4);
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() <= k || s.length() == k - 1) {
            return s.length();
        }

        char[] chars = s.toCharArray();

        char[] charArray = new char[26];

        int left = 0;
        int maxCharCount = 0;
        for (int right = 0; right < chars.length; right++) {
            final int ch = chars[right] - 'A';

            charArray[ch]++;

            int curCharCount = charArray[ch];

            maxCharCount = Math.max(maxCharCount, curCharCount);

            int curStrLen = right - left + 1;

            //현재 길이에서 가장 많은 ch의 수를 빼면, 교체해야 할 나머지 ch의 수
            //이게 k보다 크면 안되므로, left를 옮긴다.
            if (curStrLen - maxCharCount > k) {
                charArray[chars[left] - 'A']--;
                left++;
            }
        }

        //right == chars.length
        //sliding window의 너비를 구한다. => chars.length - left;
        return chars.length - left;
    }
}
