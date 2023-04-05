package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 23년 4월 6일 오전 12시 05분
// 15분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] strs = br.readLine().split(" ");
        int[] inputs = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            inputs[i] = Integer.parseInt(strs[i]);
        }

        sol.solution(inputs);
    }
}

class BjSolution {
    public void solution(int[] inputs) {
        Arrays.sort(inputs);

        int l = 0;
        int r = inputs.length - 1;
        int min = Integer.MAX_VALUE;

        int saveLVal = 0;
        int saveRVal = 0;
        while (l < r) {
            int lVal = inputs[l];
            int rVal = inputs[r];

            int sum = (lVal + rVal);
            int absSum = Math.abs(sum);

            if (min > absSum) {
                saveLVal = lVal;
                saveRVal = rVal;
                min = absSum;
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        System.out.println(saveLVal + " " + saveRVal);
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
