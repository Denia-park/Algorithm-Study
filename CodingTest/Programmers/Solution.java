package CodingTest.Programmers;

//두 원 사이의 정수 쌍

/*
1. 아이디어
두 원사이의 간격을 구하고 그 간격만큼의 점을 answer에 더하기.

2. 시간복잡도
for문을 한번만 돌면 되므로 O(n) > 100만

3. 자료구조
r1 과 r2는 백만까지 가능한데 백만의 제곱이 쓰이므로 제곱을 할 경우 오버플로우 고려해서 자료형을 크게 해줘야한다.
그리고 for문 돌리는 x도 최대 백만까지 가능하므로 제곱을 할 경우 오버플로우 고려해서 자료형을 크게 써야함
*/
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (double x = -r2 + 1.0; x < r2; x++) {
            //r2 경계 값 : 내림
            double r2Y = Math.floor(Math.sqrt(((long) r2 * r2) - (x * x)));

            if (x <= -r1 || r1 <= x) {
                //내림 값 기준으로 *2 하고 1 더해주면 사이 값 나온다.
                answer += (2 * r2Y + 1);
            } else {
                //r1 경계 값 : 올림
                double r1Y = Math.ceil(Math.sqrt(((long) r1 * r1) - (x * x)));
                //두개의 차 * 2 해서 더하기
                answer += (2 * (r2Y - r1Y + 1));
            }
        }

        //시작점과 끝점은 계산을 안해줬기 때문에 마지막에 +2를 진행함.
        answer += 2;

        return answer;
    }
}
