package CodingTest.Programmers;

/*
이분탐색 - 입국 심사

//정답 참고
//주소:https://suhyeokeee.tistory.com/183

아이디어
- 이분 탐색
- 어디를 이분 탐색해야하는지 전혀 감을 못잡았다가 정답을 보고 생각을 하게 되었다.

시간복잡도
O(nLgN) -> n이 10만이라 충분함.

자료형
시간이 10억까지 가능하기 때문에 Long을 써야 오버플로우가 나지 않음

*/

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        //심사관들이 처리하는 시간 중에 가장 작은 값과 가장 큰 값을 쓸 예정이기 때문에 sort를 한다.
        Arrays.sort(times);

        //최소 시간
        //1분 부터 해도 되지만,입국 심사 대기 인원은 최소 1명, 심사관도 최소 1명 이기 때문에
        //최소 시간으로 처리하는 심사관의 시간을 최소값으로 설정한다.
        long minTime = times[0];

        //최대 시간
        //만약 모든 사람이 가장 느린 심사관한테 가서 입국 심사를 받게 되면 걸리는 값
        long maxTime = (long) times[times.length - 1] * n;
        long answer = maxTime;

        //시간을 기준으로 이분탐색을 돌린다
        //만약 30분의 시간이 걸린다면, 30분 동안 처리할 수 있는 인원수는
        //다음과 같이 계산이 된다. 예제를 사용하면
        //30분 동안 0번째 심사관 -> 30분 / 7분 => 4.XX명이 나오는데 => 나머지는 버려야 하므로 4명 (나머지 값은 쓸수가 없다.)
        //30분 동안 1번째 심사관 -> 30분 / 10분 => 3명이 나오는데 => 3명
        //이렇게 시간을 기준으로 인원을 계산하고 계산한 인원이 n명 이상이면 해당 값을 저장
        //최소값이 될 때까지 계속해서 이분 탐색을 돌린다.

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;

            long manCount = 0;
            for (int time : times) {
                manCount += (midTime / time);
            }

            if (manCount >= n) {
                answer = Math.min(answer, midTime);

                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        return answer;
    }
}
