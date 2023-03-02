package CodingTest.Programmers;

import java.util.LinkedList;
import java.util.List;

// 문제
//https://school.programmers.co.kr/learn/courses/30/lessons/12936

// 정답
// https://hongcoding.tistory.com/55

//1번부터 n번까지 줄 서기

class Solution {
    List<Integer> list;
    int[] answer;

    public int[] solution(int n, long k) {
        list = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }

        k = k - 1; // 0번째부터 시작하기 때문에 기존 값에서 -1을 더해서 순서 값을 다시 설정한다.

        answer = new int[n];

        int idx = 0;
        while (idx != n) {
            long duplicationNum = factorial(n - idx - 1);

            int digitIdx = (int) (k / duplicationNum);

            answer[idx] = list.get(digitIdx);
            list.remove(digitIdx);

            k %= duplicationNum;

            idx++;
        }

        return answer;
    }

    private long factorial(long n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }
}
