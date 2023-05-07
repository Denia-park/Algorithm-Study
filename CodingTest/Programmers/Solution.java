package CodingTest.Programmers;

//두 원 사이의 정수 쌍

/*
1. 아이디어
두 원사이의 간격을 구하고 그 간격만큼의 점을 answer에 더하기.
2. 시간복잡도
3. 자료구조
*/
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (double x = -r2 + 1.0; x < r2; x++) {
            //r2 경계 값 : 내림
            double r2Y = Math.floor(Math.sqrt((r2 * r2) - (x * x)));

            if (x <= -r1 || r1 <= x) {
                answer += (2 * r2Y + 1);
            } else {
                //r1 경계 값 : 올림
                double r1Y = Math.ceil(Math.sqrt((r1 * r1) - (x * x)));
                //두개의 차 * 2 해서 더하기
                answer += (2 * (r2Y - r1Y + 1));
            }
        }

        answer += 2;

        return answer;
    }
}
