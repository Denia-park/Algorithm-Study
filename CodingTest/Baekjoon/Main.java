package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            sum += val;
        }
        sol.solution(arr, sum);
    }
}


class BjSolution {
    public void solution(int[] input, int sum) {
        List<int[]> combis = new ArrayList<>();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                combis.add(new int[]{i, j});
            }
        }

        for (int[] combi : combis) {
            int tempVal1 = input[combi[0]];
            int tempVal2 = input[combi[1]];

            int restVal = sum - tempVal1 - tempVal2;
            if (restVal == 100) {
                Arrays.stream(input).filter(val -> val != tempVal1 && val != tempVal2).sorted().forEach(System.out::println);
                return;
            }
        }
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
