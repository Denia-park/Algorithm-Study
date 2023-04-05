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

        int min = Integer.MAX_VALUE;

        int lVal = 0;
        int rVal = 0;
        for (int idx = 0; idx < inputs.length; idx++) {
            int tempIdx = binarySearch(idx + 1, -1 * inputs[idx], inputs);

            if (idx != tempIdx && Math.abs(inputs[idx] + inputs[tempIdx]) < min) {
                min = Math.abs(inputs[idx] + inputs[tempIdx]);
                lVal = inputs[idx];
                rVal = inputs[tempIdx];
            }

            if (idx != tempIdx - 1 && Math.abs(inputs[idx] + inputs[tempIdx - 1]) < min) {
                min = Math.abs(inputs[idx] + inputs[tempIdx - 1]);
                lVal = inputs[idx];
                rVal = inputs[tempIdx - 1];
            }

            if (idx != tempIdx + 1 && tempIdx < inputs.length - 1 && Math.abs(inputs[idx] + inputs[tempIdx + 1]) < min) {
                min = Math.abs(inputs[idx] + inputs[tempIdx + 1]);
                lVal = inputs[idx];
                rVal = inputs[tempIdx + 1];
            }
        }

        System.out.println(lVal + " " + rVal);
    }

    private int binarySearch(int startIdx, int targetVal, int[] inputs) {
        int rtVal = inputs.length - 1;

        int start = startIdx;
        int end = inputs.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (inputs[mid] >= targetVal) {
                rtVal = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return rtVal;
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
