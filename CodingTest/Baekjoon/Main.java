package CodingTest.Baekjoon;

//수 찾기 - 1920

//아이디어
//이분탐색

//시간복잡도
//O(Log N)

//자료구조
//int[]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.readLine();
        int[] quizs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sol.solution(nums, quizs);
    }
}

class BjSolution {
    public void solution(int[] nums, int[] quizs) {
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();

        for (int val : quizs) {
            sb.append(binarySearch(nums, val)).append("\n");
        }

        System.out.println(sb);
    }

    private int binarySearch(int[] nums, int val) {
        int result = 0;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == val) {
                result = 1;
                break;
            } else if (nums[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return result;
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
