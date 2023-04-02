package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//23년 4월 2일 오후 11시 55분
//12분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ignore = br.readLine();
        String arrays = br.readLine();
        ignore = br.readLine();
        String testCases = br.readLine();

        sol.solution(arrays, testCases);
    }
}

class BjSolution {

    public void solution(String arr, String testcase) {
        int[] arrInt = Arrays.stream(arr.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] testCaseInt = Arrays.stream(testcase.split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arrInt);

        int[] ans = new int[testCaseInt.length];
        int idx = 0;
        for (int tc : testCaseInt) {
            int val = 0;
            if (isExist(arrInt, tc)) {
                val = 1;
            }
            ans[idx++] = val;
        }

        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append("\n");
        }
        System.out.println(sb);
    }

    private boolean isExist(int[] arrInt, int tc) {
        int start = 0;
        int end = arrInt.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arrInt[mid] == tc) {
                return true;
            } else if (arrInt[mid] < tc) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
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
