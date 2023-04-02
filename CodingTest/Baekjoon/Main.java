package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//23년 4월 3일 오전 12시 10분
//30분 걸림

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tcn = Integer.parseInt(br.readLine());
        String[] strArr = new String[tcn];
        for (int i = 0; i < tcn; i++) {
            strArr[i] = br.readLine();
        }

        sol.solution(strArr);
    }
}

class BjSolution {
    final int BC = 1;
    final int WC = 0;
    private int size;
    private int blue, white;
    private int[][] map;

    public void solution(String[] strArr) {
        size = strArr.length;
        blue = white = 0;

        map = new int[size][size];
        int idx = 0;
        for (String s : strArr) {
            int[] arrInt = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            map[idx++] = arrInt;
        }

        check(map, 0, 0, size);

        System.out.println(white);
        System.out.println(blue);

    }

    private void check(int[][] map, int rowStart, int colStart, int size) {
        int firstColor = map[rowStart][colStart];
        boolean flag = true;

        for (int row = rowStart; row < rowStart + size; row++) {
            for (int col = colStart; col < colStart + size; col++) {
                if (map[row][col] != firstColor) {
                    flag = false;
                    break;
                }
            }

            if (!flag) break;
        }

        if (flag) {
            if (firstColor == WC) {
                white += 1;
            } else {
                blue += 1;
            }
        } else {
            int changeSize = size / 2;
            //11시
            check(map, rowStart, colStart, changeSize);
            //1시
            check(map, rowStart, colStart + changeSize, changeSize);
            //5시
            check(map, rowStart + changeSize, colStart + changeSize, changeSize);
            //7시
            check(map, rowStart + changeSize, colStart, changeSize);
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
