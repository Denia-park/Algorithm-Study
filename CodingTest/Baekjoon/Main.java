package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int row = Integer.parseInt(line[1]);
        int col = Integer.parseInt(line[2]);

        sol.solution(size, row, col);
    }
}

class BjSolution {
    int answer;
    int gRow;
    int gCol;
    int gSize;

    public void solution(int size, int row, int col) {
        answer = 0;
        gSize = size;
        gRow = row;
        gCol = col;

        for (int i = size; i >= 1; i--) {
            int halfLength = (int) Math.pow(2, (i - 1));
            int areaOfQuarter = halfLength * halfLength;
            answer += areaOfQuarter * getQuarterPosition(halfLength, row, col);
            if (row >= halfLength) {
                row -= halfLength;
            }
            if (col >= halfLength) {
                col -= halfLength;
            }
        }

        System.out.println(answer);
    }

    int getQuarterPosition(int halfLength, int row, int col) {
        if (row < halfLength && col < halfLength) {
            return 0;
        } else if (row < halfLength && col >= halfLength) {
            return 1;
        } else if (row >= halfLength && col < halfLength) {
            return 2;
        } else if (row >= halfLength && col >= halfLength) {
            return 3;
        }
        return -1;
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

