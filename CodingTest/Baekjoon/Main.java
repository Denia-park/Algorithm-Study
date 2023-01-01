package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//로봇 청소기
//현재 위치 청소
//현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색 진행
// 왼쪽이 더러우면 왼쪽회전 후 한칸 전진 -> 현재 위치 청소
// 왼쪽 방향 깨끗하면, 왼쪽 회전 후 다시 왼쪽방향부터 차례대로 탐색 진행
// 네방향이 모두 깨끗 or 벽 이면, 바라보는 방향 유지한 채로 한칸 후진 후 왼쪽 탐색
// 네방향이 모두 깨끗 or 벽 이면, 바라보는 방향 유지한 채로 한칸 후진이 불가능하면 작동 멈춤

// 로봇 청소기는 이미 청소된 칸 청소 X , 벽 통과 X

// 로봇 청소기가 있는 칸의 상태는 빈칸

// 로봇 청소기가 청소하는 칸의 개수를 출력

enum View {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    final int value;

    View(int value) {
        this.value = value;
    }

    public static View valueOf(int value) {
        switch (value) {
            case 0:
                return View.NORTH;
            case 1:
                return View.EAST;
            case 2:
                return View.SOUTH;
            case 3:
                return View.WEST;
            default:
                return null;
        }
    }
}

enum Environment {
    EMPTY(0), WALL(1), CLEAN(2);

    final int value;

    Environment(int value) {
        this.value = value;
    }

    public static Environment valueOf(int value) {
        switch (value) {
            case 0:
                return EMPTY;
            case 1:
                return WALL;
            case 2:
                return CLEAN;
            default:
                return null;
        }
    }
}

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fl = br.readLine().split(" ");
        int rowNum = Integer.parseInt(fl[0]);
        int colNum = Integer.parseInt(fl[1]);

        String[] sl = br.readLine().split(" ");

        int[][] table = new int[rowNum][colNum];

        for (int r = 0; r < rowNum; r++) {
            String[] tl = br.readLine().split(" ");
            for (int c = 0; c < colNum; c++) {
                table[r][c] = Integer.parseInt(tl[c]);
            }
        }

        sol.solution(sl, table);
    }
}

class BjSolution {
    public void solution(String[] machineCoordi, int[][] table) {
        int row = Integer.parseInt(machineCoordi[0]);
        int col = Integer.parseInt(machineCoordi[1]);
        int view = Integer.parseInt(machineCoordi[2]);

        Machine machine = new Machine(row, col, View.valueOf(view), table);

        System.out.println(machine.simulation());
    }
}

class Coordi {
    int row, col;

    Coordi(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Machine {
    int row, col;
    View view;
    Environment[][] table;
    int turnCount, cleanCount;

    public Machine(int row, int col, View view, int[][] table) {
        this.row = row;
        this.col = col;
        this.view = view;
        this.table = initIsCleaned(table);
    }

    public int simulation() {

        while (true) {
            clean();

            if (getTurnCount() == 4) {
                if (isAbleToBackUp()) {
                    backUp();
                    resetTurnCount();
                } else {
                    break;
                }
            } else {
                if (isAbleToCleanOnLeftSide()) {
                    changeView();
                    go();
                    resetTurnCount();
                } else {
                    changeView();
                    upTurnCount();
                }
            }
        }

        return cleanCount;
    }

    private Environment[][] initIsCleaned(int[][] table) {
        Environment[][] returnTable = new Environment[table.length][table[0].length];
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                returnTable[r][c] = Environment.valueOf(table[r][c]);
            }
        }

        return returnTable;
    }

    public void clean() {
        if (this.table[this.row][this.col] != Environment.EMPTY)
            return;

        this.table[this.row][this.col] = Environment.CLEAN;
        cleanCount++;
    }

    public int getTurnCount() {
        return this.turnCount;
    }

    public void upTurnCount() {
        turnCount++;
    }

    public void resetTurnCount() {
        turnCount = 0;
    }

    public boolean isAbleToCleanOnLeftSide() {
        Coordi turnCoordi = getTurnCoordi(this.row, this.col);

        return this.table[turnCoordi.row][turnCoordi.col] == Environment.EMPTY;
    }

    public boolean isAbleToBackUp() {
        Coordi backUpCoordi = getBackCoordi(this.row, this.col);

        return this.table[backUpCoordi.row][backUpCoordi.col] != Environment.WALL;
    }

    public Coordi getBackCoordi(int curRow, int curCol) {
        if (this.view == View.NORTH) {
            curRow++;
        } else if (this.view == View.EAST) {
            curCol--;
        } else if (this.view == View.SOUTH) {
            curRow--;
        } else { //West
            curCol++;
        }

        return new Coordi(curRow, curCol);
    }

    public Coordi getTurnCoordi(int curRow, int curCol) {
        if (this.view == View.NORTH) {
            curCol--;
        } else if (this.view == View.EAST) {
            curRow--;
        } else if (this.view == View.SOUTH) {
            curCol++;
        } else { //West
            curRow++;
        }

        return new Coordi(curRow, curCol);
    }

    public void go() {
        if (this.view == View.NORTH) {
            this.row--;
        } else if (this.view == View.EAST) {
            this.col++;
        } else if (this.view == View.SOUTH) {
            this.row++;
        } else { //West
            this.col--;
        }
    }

    public void backUp() {
        if (this.view == View.NORTH) {
            this.row++;
        } else if (this.view == View.EAST) {
            this.col--;
        } else if (this.view == View.SOUTH) {
            this.row--;
        } else { //West
            this.col++;
        }
    }

    private void changeView() {
        int tempViewValue = this.view.value;

        tempViewValue += 3;
        tempViewValue %= 4;

        this.view = View.valueOf(tempViewValue);
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
