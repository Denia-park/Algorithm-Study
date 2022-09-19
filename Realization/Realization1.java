package Realization;

//시각
    // 문제 해결 아이디어
        // 이 문제는 가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있는 문제
        // 하루는 86,400초 이므로 컴퓨터가 충분히 모두 연산을 할만하다.
        //따라서 단순히 시각을 1씩 증가시키면서 3이 하나라도 포함되어 있는지를 확인
        //이러한 유형은 완전 탐색 문제 유형이라고 불림
            //가능한 경우의 수를 모두 검사해보는 탐색방법

public class Realization1 {
    public static void main(String[] args) {
        System.out.println(solve1(5));
        System.out.println(solve2(5));
    }

    private static int solve1(int quizHour) {
        int answer = 0;

        int hour = 0;
        int min = 0;
        int sec = 0;

        int counter = 0;

        int clockLimit = 3600 * (quizHour + 1); // +1 을 해줘야 함

        while(counter < clockLimit) {

            String checkVal = String.valueOf(hour) + String.valueOf(min) + String.valueOf(sec);
            if(checkVal.contains("3")) {
                answer++;
            }

            counter++;

            sec++;
            if(sec == 60) {
                min++;
                sec = 0;
            }

            if(min == 60) {
                hour++;
                min = 0;
            }
        }

        return answer;
    }

    private static int solve2(int quizHour) {
        int answer = 0;

        for (int hour = 0; hour < quizHour + 1; hour++) {
            for (int min = 0; min < 60; min++) {
                for (int sec = 0; sec < 60; sec++) {
                    if((String.valueOf(hour) + String.valueOf(min) + String.valueOf(sec)).contains("3"))
                        answer ++;
                }
            }
        }

        return answer;
    }
}
