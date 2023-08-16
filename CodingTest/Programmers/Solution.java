package CodingTest.Programmers;

import java.util.Arrays;

/*
아이디어
- A의 순서에 따라 B의 순서를 맞출 수 있으므로, 두 배열의 순서는 마음껏 바꿔도 된다.
    - 두 배열을 정렬한다.
- 최대 점수를 위해서는, 최대한 지는 것을 피하고, 다음으로는 비기는게 더 낫고, 최선은 이기는 것
- A 인덱스, B 인덱스 따라가면서 값을 비교하고 -> 구하지 못한 값들은 진 것과 같다.
- 이길때까지 B 인덱스 증가, 이기면 A랑 B랑 같이 인덱스 증가 -> B 인덱스가 끝나는 순간 게임 종료.

시간복잡도
- O(n)

자료구조

 */
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;
        while (bIdx < B.length) {
            final int aVal = A[aIdx];
            final int bVal = B[bIdx];

            if (aVal < bVal) {
                aIdx++;
                bIdx++;

                answer++;
            } else if (aVal > bVal) {
                bIdx++;
            } else {
                bIdx++;
            }
        }

        return answer;
    }
}
