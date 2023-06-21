package CodingTest.Baekjoon;

//빗물 14719

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = inputs[0];
        int col = inputs[1];

        int[] heightArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sol.solve(row, col, heightArr);
    }
}

class BjSolution {
    public void solve(int row, int col, int[] heightArr) {
        int answer = 0;

        int[][] map = new int[row][col];
        int cIdx = 0;

        for (int height : heightArr) {
            int rIdx = row - 1;
            for (int count = 0; count < height; count++) {
                map[rIdx][cIdx] = 1;
                rIdx--;
            }

            cIdx++;
        }

        for (int r = 0; r < row; r++) {
            //시작 값 초기화, 벽이 없는 상태
            boolean isLeftWallClosed = false;
            //빗물 저정할 값
            int tempSaveWater = 0;

            for (int c = 0; c < col; c++) {
                //벽이 있으면
                //벽 상태 초기화 + 이전에 고인 빗물이 있으면 answer에 추가
                if (isWall(map, r, c)) {
                    if (isLeftWallClosed) {
                        answer += tempSaveWater;
                        tempSaveWater = 0;
                    }

                    isLeftWallClosed = true;
                } else {
                    //지금이 비었고, 이전에 벽이 있었으면 비가 고임
                    if (isLeftWallClosed) {
                        tempSaveWater++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private boolean isWall(final int[][] map, final int r, final int c) {
        return map[r][c] == 1;
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
