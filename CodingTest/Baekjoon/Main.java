package CodingTest.Baekjoon;

//수열 2559
//오후 10시 28분 - 시작
//오후 10시 42분 - 완료
//생각을 잘못해서 3~4분 더 걸림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits1 = br.readLine().split(" ");
        int totalNum = Integer.parseInt(splits1[0]);
        int needNum = Integer.parseInt(splits1[1]);

        String[] splits2 = br.readLine().split(" ");
        int[] values = new int[totalNum];

        for (int i = 0; i < splits2.length; i++) {
            values[i] = Integer.parseInt(splits2[i]);
        }

        sol.solution(values, needNum);
    }
}

/*
아이디어
투포인터

- 출력
최대 합

시간복잡도
투포인터 -> O(N)

자료구조
결과값 - 100 * 100000 -> 10억 -> int
10만칸 -> int[]
 */

class BjSolution {

    public void solution(int[] values, int needNum) {
        int maxVal = Integer.MIN_VALUE;
        int start = 0;
        int end = needNum - 1;

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += values[i];
        }

        maxVal = Math.max(maxVal, sum);

        for (int i = end + 1; i <= (values.length - 1); i++) {
            sum -= values[i - 1 - end];
            sum += values[i];

            maxVal = Math.max(maxVal, sum);
        }

        System.out.println(maxVal);
    }
}

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }
