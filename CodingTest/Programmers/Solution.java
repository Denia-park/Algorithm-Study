package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;

// 문제 - 1번부터 n번까지 줄 서기
//https://school.programmers.co.kr/learn/courses/30/lessons/12936
// 정답
// https://tosuccess.tistory.com/75

class Solution {
    List<Integer> list;
    int[] answer;

    public int[] solution(int n, long k) {
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        list = new ArrayList<>(21);
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        k = k - 1; // 0번째부터 시작하기 때문에 기존 값에서 -1을 더해서 순서 값을 다시 설정한다.

        answer = new int[n];

        int idx = 0;
        while (idx != n) {
            long duplicationNum = factorial[n - idx - 1];

            int digitIdx = (int) (k / duplicationNum);

            answer[idx] = list.remove(digitIdx);

            k %= duplicationNum;

            idx++;
        }

        return answer;
    }
}
