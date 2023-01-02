package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fl = br.readLine().split(" ");
        int colNum = Integer.parseInt(fl[0]);
        int rowNum = Integer.parseInt(fl[1]);

        char[][] table = new char[rowNum][colNum];

        for (int r = 0; r < rowNum; r++) {
            table[r] = br.readLine().toCharArray();
        }

        sol.solution(rowNum, colNum, table);
    }
}

class BjSolution {
    final char WHITE = 'W';
    final char BLUE = 'B';
    int gRowNum, gColNum;
    int whitePower, bluePower;
    char[][] gTable;
    boolean[][] isVisited;

    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solution(int rowNum, int colNum, char[][] table) {
        gRowNum = rowNum;
        gColNum = colNum;
        gTable = table;
        whitePower = 0;
        bluePower = 0;

        isVisited = new boolean[rowNum][colNum];

        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (isVisited[r][c]) continue;

                bfs(r, c);
            }
        }

        System.out.println("" + whitePower + " " + bluePower);
    }

    private void bfs(int r, int c) {
        Deque<Coordi> dq = new ArrayDeque<>();
        isVisited[r][c] = true;
        dq.addLast(new Coordi(r, c));
        char curColor = gTable[r][c];
        int count = 0;

        while (!dq.isEmpty()) {
            Coordi curCoordi = dq.pollFirst();
            int curRow = curCoordi.row;
            int curCol = curCoordi.col;
            count++;

            for (int[] dir : directions) {
                int nr = curRow + dir[0];
                int nc = curCol + dir[1];

                if (nr >= 0 && nr < gRowNum && nc >= 0 && nc < gColNum) {
                    if (!isVisited[nr][nc] && gTable[nr][nc] == curColor) {
                        isVisited[nr][nc] = true;
                        dq.addLast(new Coordi(nr, nc));
                    }
                }
            }
        }

        if (curColor == WHITE) {
            whitePower += Math.pow(count, 2);
        } else {
            bluePower += Math.pow(count, 2);
        }
    }
}

class Coordi {
    int row, col;

    Coordi(int row, int col) {
        this.row = row;
        this.col = col;
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
