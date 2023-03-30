package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            sol.solution(br.readLine());
        }
    }
}


class BjSolution {
    public void solution(String input) {
        int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int peopleNum = arr[0];
        int sum = 0;
        for (int i = 1; i <= peopleNum; i++) {
            sum += arr[i];
        }
        float avg = (float) sum / peopleNum;

        int count = 0;
        for (int i = 1; i <= peopleNum; i++) {
            if (arr[i] > avg) {
                count++;
            }
        }

        System.out.printf("%.3f" + "%%" + "%n", (float) count * 100 / peopleNum);
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
