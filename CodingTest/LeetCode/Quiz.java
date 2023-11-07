package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("ab", "a"));
        System.out.println(solution.checkInclusion("ky", "ainwkckifykxlribaypk"));
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Len = s1.length();
        int[] s1Arr = new int[26];

        //기존 단어를 세어둔다.
        countChar(s1, s1Arr);

        //s2에서 s1의 첫글자를 찾고, s1에 해당하는 길이만큼 떼어내서 비교한다.
        int searchIdx = -1;
        String firstChar = s1.charAt(0) + "";
        while (true) {
            searchIdx = s2.indexOf(firstChar, searchIdx + 1);
            if (searchIdx == -1) {
                break;
            }

            //위쪽으로 찾기
            final int upStartIdx = searchIdx - (s1Len - 1);
            if (-1 < upStartIdx) {
                String tempStr = s2.substring(upStartIdx, searchIdx + 1);

                int[] s2Arr = new int[26];
                countChar(tempStr, s2Arr);

                if (Arrays.equals(s1Arr, s2Arr)) {
                    return true;
                }
            }

            //아래쪽으로 찾기
            final int downEndIdx = searchIdx + (s1Len - 1);
            if (downEndIdx < s1Len) {
                String tempStr = s2.substring(searchIdx, downEndIdx + 1);

                int[] s2Arr = new int[26];
                countChar(tempStr, s2Arr);

                if (Arrays.equals(s1Arr, s2Arr)) {
                    return true;
                }
            }

            searchIdx++;
        }

        return false;
    }

    private void countChar(final String str, final int[] arr) {
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
    }
}
