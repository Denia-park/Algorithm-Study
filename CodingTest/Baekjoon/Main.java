package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//정답 참고 - 센서 [2212]

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int studentNum = Integer.parseInt(inputs[0]);
        int groupNum = Integer.parseInt(inputs[1]);
        int[] students = new int[studentNum];
        String[] studentInfos = br.readLine().split(" ");
        for (int i = 0; i < studentNum; i++) {
            students[i] = Integer.parseInt(studentInfos[i]);
        }
        sol.solution(studentNum, groupNum, students);
    }
}

class BjSolution {
    public void solution(int studentNum, int groupNum, int[] students) {
        if (groupNum >= studentNum) {
            System.out.println(0);
            return;
        }

        int[] diffs = new int[studentNum - 1];

        for (int i = 0; i < studentNum - 1; i++) {
            diffs[i] = students[i + 1] - students[i];
        }

        int jump = groupNum - 1;

        //정렬
        Arrays.sort(diffs);

        int answer = 0;
        for (int i = diffs.length - 1; i >= 0; i--) {
            if (jump > 0) {
                jump--;
                continue;
            }

            answer += diffs[i];
        }

        System.out.println(answer);
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
