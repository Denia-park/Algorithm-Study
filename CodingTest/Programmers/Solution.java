package CodingTest.Programmers;

class Solution {
    private int maxRow, maxCol;
    private int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int[] solution(String[] keyinput, int[] board) {
        maxRow = board[0] / 2;
        maxCol = board[1] / 2;

        int[] curr = {0, 0};
        int tempRow = 0;
        int tempCol = 0;

        for (String s : keyinput) {
            tempRow = curr[0];
            tempCol = curr[1];
            switch (s) {
                case "up":
                    tempRow += directions[0][0];
                    tempCol += directions[0][1];
                    break;
                case "down":
                    tempRow += directions[1][0];
                    tempCol += directions[1][1];
                    break;
                case "left":
                    tempRow += directions[2][0];
                    tempCol += directions[2][1];
                    break;
                case "right":
                    tempRow += directions[3][0];
                    tempCol += directions[3][1];
                    break;
                default:
                    break;
            }
            if (isNotMovable(tempRow, tempCol)) continue;

            curr[0] = tempRow;
            curr[1] = tempCol;
        }
        return curr;
    }

    boolean isNotMovable(int row, int col) {
        return row < -maxRow || row > maxRow || col < -maxCol || col > maxCol;
    }
}
