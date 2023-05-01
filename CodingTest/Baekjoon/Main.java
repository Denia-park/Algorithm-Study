package CodingTest.Baekjoon;

//동전 0 - 11047

//아이디어
//그리디

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int count = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        sol.solution(nums, target);
    }
}

class BjSolution {
    public void solution(int[] nums, int target) {
        int answer = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            answer += target / num;
            target %= num;
            if (target == 0) {
                break;
            }
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
