package CodingTest.Baekjoon;

//로봇 청소기 14503
//오후 4시 21분 - 시작
//오후 5시 6분 - 완료
//45분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits1 = br.readLine().split(" ");
        int mapRow = Integer.parseInt(splits1[0]);
        int mapCol = Integer.parseInt(splits1[1]);

        String[] splits2 = br.readLine().split(" ");
        int[][] map = new int[mapRow][mapCol];
        for (int i = 0; i < mapRow; i++) {
            String[] tempSplits = br.readLine().split(" ");
            for (int j = 0; j < mapCol; j++) {
                map[i][j] = Integer.parseInt(tempSplits[j]);
            }
        }

        sol.solution(map, mapRow, mapCol, splits2);
    }
}

/*
아이디어
시뮬레이션

- 출력
총 청소한 칸

시간복잡도
제대로 구현만 하면 문제 없음

자료구조
객체를 사용
 */

class BjSolution {
    public void solution(int[][] map, int mapRow, int mapCol, String[] splits2) {
        int machinRow = Integer.parseInt(splits2[0]);
        int machinCol = Integer.parseInt(splits2[1]);
        int direction = Integer.parseInt(splits2[2]);

        System.out.println(new Machine(machinRow, machinCol, direction, map).run());
    }
}

class Machine {
    final int PLACE = 0;
    final int WALL = 1;
    final int CLEAN = 2;
    int r, c, d, count;
    int[][] map;
    int mapRow, mapCol;
    //전진 : 현재 값 그대로 사용
    //후진 : 0->2, 2->0, 1->3, 3->1 (후진은 현재 direction에 2 더하고 % 4 )
    //반시계 방향 회전 : 0->3 , 1->0, 2->1,  3->2 (3 더하고 % 4)
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //북,동,남,서
    int[][] goBackDirection = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public Machine(int r, int c, int d, int[][] map) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.map = map;
        this.mapRow = map.length;
        this.mapCol = map[0].length;
        this.count = 0;
    }

    public int run() {
        while (true) {
            clean();

            if (areAllSurroundingsClean()) {
                //후진할수없으면 작동을 멈춘다.
                if (!isAvailableGoBack()) {
                    break;
                }

                //방향 유지 후 한칸 후진
                goBack();
                //1번으로 돌아간다.
                continue;
            }

            while (true) {
                turnLeft();
                if (isPlaceInFrontOfMachineDirty()) {
                    go();
                    break;
                }
            }
        }

        return this.count;
    }

    private void go() {
        this.r = getGoPosition()[0];
        this.c = getGoPosition()[1];
    }

    private boolean isPlaceInFrontOfMachineDirty() {
        int nR = getGoPosition()[0];
        int nC = getGoPosition()[1];

        return !isOutOfMap(nR, nC) && !isWall(nR, nC) && !isCleaned(nR, nC);
    }

    private void turnLeft() {
        this.d = (this.d + 3) % 4;
    }

    private void clean() {
        if (isCleaned(this.r, this.c)) return;
        map[r][c] = CLEAN;
        this.count++;
    }

    private boolean isCleaned(int r, int c) {
        return map[r][c] == CLEAN;
    }

    private boolean areAllSurroundingsClean() {
        //북동남서 확인
        //청소되지 않은 빈칸인지만 확인
        for (int[] direction : directions) {
            int nR = r + direction[0];
            int nC = c + direction[1];

            if (isOutOfMap(nR, nC) || isWall(nR, nC) || isCleaned(nR, nC)) continue;

            //더러우면
            return false;
        }

        return true;
    }

    private boolean isWall(int r, int c) {
        return map[r][c] == WALL;
    }

    private boolean isOutOfMap(int r, int c) {
        return r < 0 || r >= mapRow || c < 0 || c >= mapCol;
    }

    private int[] getGoPosition() {
        int nR = this.r + directions[d][0];
        int nC = this.c + directions[d][1];

        return new int[]{nR, nC};
    }

    private int[] getGoBackPosition() {
        int nR = this.r + goBackDirection[d][0];
        int nC = this.c + goBackDirection[d][1];

        return new int[]{nR, nC};
    }

    private boolean isAvailableGoBack() {
        int nR = getGoBackPosition()[0];
        int nC = getGoBackPosition()[1];

        return !isOutOfMap(nR, nC) && !isWall(nR, nC);
    }

    private void goBack() {
        this.r = getGoBackPosition()[0];
        this.c = getGoBackPosition()[1];
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
