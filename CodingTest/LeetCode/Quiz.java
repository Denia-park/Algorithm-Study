package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.sortVowels("lEetcOde").equals("lEOtcede"));
        System.out.println(solution.sortVowels("lYmpH").equals("lYmpH"));
    }
}

//permuation
//자음 자리 유지
//모음은 오름차순으로 정렬

class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                indexs.add(i);
                vowels.add(ch);
            }
        }

        vowels.sort(null);

        for (int i = 0; i < indexs.size(); i++) {
            sb.setCharAt(indexs.get(i), vowels.get(i));
        }

        return sb.toString();
    }

    private boolean isVowel(final char ch) {
        return Character.toLowerCase(ch) == 'a'
                || Character.toLowerCase(ch) == 'e'
                || Character.toLowerCase(ch) == 'i'
                || Character.toLowerCase(ch) == 'o'
                || Character.toLowerCase(ch) == 'u';
    }
}
