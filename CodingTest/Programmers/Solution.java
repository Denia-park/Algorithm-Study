package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
동적계획법(Dynamic Programming) - N으로 표현
※비슷한 아이디어까지 갔는데 직접적 구현을 못해서 답 참고
//주소:https://gurumee92.tistory.com/164

아이디어
- DP 동적 계획법 + 완탐
- 미리 값을 저장해두긴 해야함.
- 모든 값을 이용해서 계산을 한다.
- 최솟값이 8보다 크면 -1을 return

시간복잡도
O(N^4)

자료형
Set의 List 사용

*/
class Solution {
    final int COUNT_LIMIT = 8;

    public int solution(int N, int number) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < COUNT_LIMIT + 1; i++) {
            sets.add(new HashSet<>());
        }

        for (int totalCnt = 1; totalCnt <= COUNT_LIMIT; totalCnt++) {
            Set<Integer> curSet = sets.get(totalCnt);
            curSet.add(Integer.parseInt(String.valueOf(N).repeat(totalCnt)));

            for (int leftCnt = 1; leftCnt < totalCnt; leftCnt++) {
                Set<Integer> lSet = sets.get(leftCnt);
                Set<Integer> rSet = sets.get(totalCnt - leftCnt);

                lSet.forEach(l -> rSet.forEach(r -> {
                    curSet.add(l + r);
                    curSet.add(l - r);
                    curSet.add(l * r);
                    if (r != 0)
                        curSet.add(l / r);
                }));

            }

            if (curSet.contains(number)) {
                return totalCnt;
            }
        }

        return -1;
    }
}
