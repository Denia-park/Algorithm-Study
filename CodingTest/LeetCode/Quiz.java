package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
- 16 * 16 -> 2^8

자료구조
- dfs (재귀)

 */

class Solution {
    List<String> combi;

    public int maxLength(final List<String> arr) {
        combi = new ArrayList<>();

        //백 트래킹으로 구하자. -> 모든 조합 구하기
        for (int combiCount = 1; combiCount <= arr.size(); combiCount++) {
            getCombi(-1, arr, combiCount, new ArrayDeque<>());
        }

        int answer = 0;
        //각 조합에 대해서 unique 한지 확인하기, 가능 하면 max 값 업데이트
        for (final String target : combi) {
            if (isUnique(target)) {
                answer = Math.max(answer, target.length());
            }
        }

        return answer;
    }

    private boolean isUnique(final String target) {
        final int[] arr = new int[26];
        final char[] chars = target.toCharArray();

        for (final char ch : chars) {
            final int curIdx = ch - 'a';

            if (arr[curIdx] > 0) {
                return false;
            }

            arr[curIdx]++;
        }

        return true;
    }

    private void getCombi(final int startIdx, final List<String> arr, final int combiCount, final Deque<String> saveQueue) {
        if (saveQueue.size() == combiCount) {
            combi.add(String.join("", saveQueue));
            return;
        }

        for (int idx = startIdx + 1; idx < arr.size(); idx++) {
            final String curString = arr.get(idx);

            saveQueue.addLast(curString);
            getCombi(idx, arr, combiCount, saveQueue);
            saveQueue.pollLast();
        }
    }
}
