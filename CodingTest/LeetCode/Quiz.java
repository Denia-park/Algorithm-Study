package CodingTest.LeetCode;

import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.maxLength(
                List.of("un", "iq", "ue")
        ));
        System.out.println("2 : " + solution.maxLength(
                List.of("cha", "r", "act", "ers")
        ));
    }
}

/*
아이디어
- 백트래킹

시간복잡도
- 2^n (getCombi(), n은 arr의 길이) * m (isUnique(), m은 가장 긴 문자열의 길이)
=> (2^16) * (16*26) == 27262976

자료구조
- dfs (재귀)

 */

class Solution {

    private int answer;

    public int maxLength(final List<String> arr) {
        answer = 0;

        getCombi(arr, 0, "");

        return answer;
    }

    private void getCombi(final List<String> arr, final int startIdx, final String path) {
        if (!isUnique(path)) return;

        answer = Math.max(answer, path.length());

        for (int idx = startIdx; idx < arr.size(); idx++) {
            getCombi(arr, idx + 1, path + arr.get(idx));
        }
    }

    private boolean isUnique(final String target) {
        final int[] arr = new int[26];

        for (final char ch : target.toCharArray()) {
            final int curIdx = ch - 'a';

            if (arr[curIdx] > 0) return false;

            arr[curIdx]++;
        }

        return true;
    }
}
