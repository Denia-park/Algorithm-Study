package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        sol.solution(input);
    }
}

class BjSolution {

    public void solution(String originInput) {
        String[] input = originInput.split(" ");
        int fixedCost = Integer.parseInt(input[0]);
        int variableCost = Integer.parseInt(input[1]);
        int productCost = Integer.parseInt(input[2]);

        if (variableCost >= productCost) {
            System.out.println(-1);
            return;
        }

        int diff = productCost - variableCost;
        int answer;
        if (fixedCost % diff != 0) {
            answer = (int) Math.ceil((float) (fixedCost) / diff);
        } else {
            answer = (fixedCost / diff) + 1;
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
