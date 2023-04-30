package CodingTest.Baekjoon;

//수열 - 2559

//계획
//투포인터 - 연속적인 일자의 합

//출력
//가장 큰 값 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int totalNum = Integer.parseInt(inputs[0]);
        int count = Integer.parseInt(inputs[1]);
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sol.solution(nums, count);
    }
}

class BjSolution {
    public void solution(int[] nums, int count) {
        //투포인터 -> O(n)
        int start = 0;
        int end = start + count - 1;
        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        
        long maxValue = sum;

        for (int i = 1; i <= nums.length - count; i++) {
            start++;
            end++;
            sum += nums[end];
            sum -= nums[start - 1];

            maxValue = Math.max(maxValue, sum);
        }

        System.out.println(maxValue);
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
