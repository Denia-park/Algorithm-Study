package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        sol.solution(arraySize, input);
    }
}

class BjSolution {
    public void solution(int arraySize, String[] quizNum) {
        int left = 0;
        int right = arraySize - 1;

        int lSaveVal = 0;
        int rSaveVal = arraySize - 1;

        int curDiffVal = Integer.MAX_VALUE;

        while (left < right) {
            int lVal = Integer.parseInt(quizNum[left]);
            int rVal = Integer.parseInt(quizNum[right]);
            if (lVal + rVal == 0) {
                System.out.println(lVal + " " + rVal);
                return;
            }

            if (Math.abs(lVal + rVal) < curDiffVal) {
                curDiffVal = Math.abs(lVal + rVal);
                lSaveVal = lVal;
                rSaveVal = rVal;
            }

            if (lVal + rVal > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(lSaveVal + " " + rSaveVal);
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
