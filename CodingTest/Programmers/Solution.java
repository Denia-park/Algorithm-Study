package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(final int[][] routes) {
        int answer = 0;

        //끝나는 거리 순으로 정렬을 한다.
        //시작하는 거리는 무조건 끝나는 거리 이전이다.
        Arrays.sort(routes, Comparator.comparingInt((int[] value) -> value[1]));

        //0번째 차를 비교하기 위해 시작하는 거리 -1로 값을 초기화한다.
        int preCarEnd = -30001;

        //모든 차를 돌면서 비교한다.
        for (final int[] route : routes) {
            //현재 차의 시작하는 거리가 이전 차의 끝나는 거리보다 안쪽이면 (작으면)
            //현재 차가 이전 차가 끝나기 전에 들어왔으므로 카메라는 추가할 필요가 없다.
            if (preCarEnd >= route[0]) continue;

            //조건에 맞지 않으면, 이전 차랑 현재 차가 만나지 않으므로 카메라를 추가한다.
            answer++;
            //새로운 차에 대해서 끝나는 거리를 업데이트 한다.
            preCarEnd = route[1];
        }

        return answer;
    }
}
