import java.util.LinkedList;
import java.util.Queue;

//정답 참고
//전제
class Solution {
    final char FIELD = '.';
    final char FENCE = '#';
    final char SHEEP = 'o';
    final char WOLF = 'v';
    int gRow;
    int gCol;
    char[][] gTable;
    int sheep;
    int wolf;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solution(int R, int C, char[][] table) {
        gRow = R;
        gCol = C;
        gTable = table;
        sheep = 0;
        wolf = 0;

        int[] answer = new int[2];

        for (int row = 0; row < gRow; row++) {
            for (int col = 0; col < gCol; col++) {
                if (table[row][col] != FENCE) {
                    bfs(row, col);
                }
            }
        }

        answer[0] = sheep;
        answer[1] = wolf;

        System.out.printf("%d %d\n", answer[0], answer[1]);
    }

    private void bfs(int row, int col) {
        int tempWolf = 0;
        int tempSheep = 0;

        Queue<Coordination> queue = new LinkedList<>();


        while (!queue.isEmpty()) {
            Coordination tempCoordi = queue.poll();
            int cR = tempCoordi.row;
            int cC = tempCoordi.col;

            for (int i = 0; i < directions.length; i++) {
                int newRow = cR + directions[i][0];
                int newCol = cC + directions[i][1];

                if (isOutOfTable(newRow, newCol)) continue;

                if (gTable[newRow][newCol] != FENCE) {
                    if (gTable[cR][cC] == WOLF) {
                        tempWolf++;
                    } else if (gTable[cR][cC] == SHEEP) {
                        tempSheep++;
                    }
                    gTable[cR][cC] = FENCE;
                    queue.add(new Coordination(newRow, newCol));
                }
            }
        }
    }

    private void checkTableValue(int row, int col, Queue<Coordination> queue, int tempWolf, int tempSheep) {
        if (gTable[row][col] == WOLF) {
            tempWolf++;
        } else if (gTable[row][col] == SHEEP) {
            tempSheep++;
        }
        gTable[row][col] = FENCE;
        queue.add(new Coordination(row, col));
    }

    private boolean isOutOfTable(int row, int col) {
        return row < 0 || row >= gRow || col < 0 || col >= gCol;
    }
}

class Coordination {
    int row;
    int col;

    Coordination(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
