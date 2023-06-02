package CodingTest.Baekjoon;

//수 찾기 2559

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalNum = Integer.parseInt(br.readLine());
        String[] splits1 = br.readLine().split(" ");
        int[] nums = new int[totalNum];
        for (int i = 0; i < totalNum; i++) {
            nums[i] = Integer.parseInt(splits1[i]);
        }
        int findTotalNum = Integer.parseInt(br.readLine());
        String[] splits2 = br.readLine().split(" ");
        int[] findNums = new int[findTotalNum];
        for (int i = 0; i < findTotalNum; i++) {
            findNums[i] = Integer.parseInt(splits2[i]);
        }

        sol.solution(nums, findNums);
    }
}

/*
아이디어
최대 10만개의 수를 10만번 검색해야 함 -> 이진 탐색

- 출력
존재하면 1, 없으면 0

시간복잡도
이진탐색 -> O(N*lnN)

자료구조
모든 정수의 범위는 int -> int[]
 */

class BjSolution {
    public void solution(int[] nums, int[] findNums) {
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int findNum : findNums) {
            int val = binarySearch(nums, findNum);
            sb.append(val).append("\n");
        }

        System.out.println(sb);
    }

    private int binarySearch(int[] nums, int findNum) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = (st + end) / 2;

            int tempVal = nums[mid];

            if (tempVal == findNum) {
                return 1;
            } else if (tempVal < findNum) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
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
