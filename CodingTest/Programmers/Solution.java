package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//정답 참고
//출처: https://comdoc.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%B9%EA%B5%AC-%EC%97%B0%EC%8A%B5
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        int idx = 0;

        for (int[] ball : balls) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            int ballX = ball[0];
            int ballY = ball[1];

            List<int[]> fourSideLineSymmetry = new ArrayList<>();
            fourSideLineSymmetry.add(new int[]{-ballX, ballY}); // 왼쪽 대칭
            fourSideLineSymmetry.add(new int[]{2 * m - ballX, ballY}); // 오른쪽 대칭
            fourSideLineSymmetry.add(new int[]{ballX, 2 * n - ballY}); // 위쪽 대칭
            fourSideLineSymmetry.add(new int[]{ballX, -ballY}); // 아래쪽 대칭

            for (int[] symmetryCoordinate : fourSideLineSymmetry) {
                int symmetryX = symmetryCoordinate[0];
                int symmetryY = symmetryCoordinate[1];

                if (startY == ballY) {
                    //왼쪽 대칭이 문제일 경우
                    if (symmetryX < ballX && ballX < startX) {
                        continue;
                    }
                    //오른쪽 대칭이 문제일 경우
                    else if (symmetryX > ballX && ballX > startX) {
                        continue;
                    }
                } else if (startX == ballX) {
                    //위쪽 대칭이 문제일 경우
                    if (symmetryY > ballY && ballY > startY) {
                        continue;
                    }
                    //아래쪽 대칭이 문제일 경우
                    else if (symmetryY < ballY && ballY < startY) {
                        continue;
                    }
                }

                minQueue.add((int) (Math.pow((symmetryX - startX), 2) + Math.pow((symmetryY - startY), 2)));
            }

            answer[idx] = minQueue.poll();
            idx++;
        }

        return answer;
    }
}
