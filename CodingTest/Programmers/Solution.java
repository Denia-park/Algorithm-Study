package CodingTest.Programmers;

//요격 시스템

//최소한의 요격 미사일로 A나라의 미사일을 다 막야함
//시작 좌표와 끝 좌표에서 쏘는 미사일로는 막을수가 없음

//targets를 정렬 (시작 좌표가 짧은 것 + 끝 좌표가 짧은 순으로)

import java.util.Arrays;

//시작좌표 짧은 애를 기준으로 끝 좌표를 보면서 한번에 요격되는 애들은 하나의 미사일로 처리
//도저히 처리할 수 없으면 다음 미사일로 처리
class Solution {
    final int START = 0;
    final int END = 1;


    public int solution(int[][] targets) {
        Arrays.sort(targets, (t1, t2) -> {
            if (t1[START] == t2[START]) {
                return t1[END] - t2[END];
            } else {
                return t1[START] - t2[START];
            }
        });

        //맨 처음에는 기준이 없으므로
        //첫번째 미사일을 기준으로 삼는다.
        int missleStart = targets[0][START];
        int missleEnd = targets[0][END];
        int answer = 1;

        for (int idx = 1; idx < targets.length; idx++) {
            int[] newMissle = targets[idx];

            //새로운 미사일이 기존 미사일의 끝 이전에 있으므로 해당 미사일은 같이 터트릴수 있다.
            if (newMissle[START] < missleEnd) {
                continue;
            }

            missleEnd = newMissle[END];
            answer++;
        }

        return answer;
    }
}
