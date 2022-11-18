import java.util.Arrays;
import java.util.List;

class Solution {
    public void solution(String[] startLine, List<String[]> map, String[] commandList) {
        int MAX_ROW = Integer.parseInt(startLine[0]);
        int MAX_COL = Integer.parseInt(startLine[1]);
        int CUR_ROW = Integer.parseInt(startLine[2]);
        int CUR_COL = Integer.parseInt(startLine[3]);

        Dice dice = new Dice(MAX_ROW, MAX_COL, CUR_ROW, CUR_COL, map);

        for (String command : commandList) {
            dice.move(Integer.parseInt(command));
        }
    }

}

class Dice {
    int MAX_ROW;
    int MAX_COL;
    int row;
    int col;
    String[] diceSide;
    List<String[]> map;

    int[] horizontal = {4, 1, 3};
    int[] vertical = {2, 1, 5, 6};

    public Dice(int maxRow, int maxCol, int curRow, int curCol, List<String[]> map) {
        this.MAX_ROW = maxRow;
        this.MAX_COL = maxCol;
        this.map = map;
        this.row = curRow;
        this.col = curCol;
        this.diceSide = new String[7];
        Arrays.fill(diceSide, "0");
    }

    boolean isOutOfTable(int row, int col) {
        return row < 0 || row >= this.MAX_ROW || col < 0 || col >= this.MAX_COL;
    }

    void changeDiceSide(int directionNumber) {
        switch (directionNumber) {
            case 1://동
                int saveRightValue = this.horizontal[2];
                this.horizontal[2] = this.horizontal[1];
                this.horizontal[1] = this.horizontal[0];
                this.horizontal[0] = this.vertical[3];
                this.vertical[3] = saveRightValue;
                this.vertical[1] = this.horizontal[1];
                break;
            case 2://서
                int saveLeftValue = this.horizontal[0];
                this.horizontal[0] = this.horizontal[1];
                this.horizontal[1] = this.horizontal[2];
                this.horizontal[2] = this.vertical[3];
                this.vertical[3] = saveLeftValue;
                this.vertical[1] = this.horizontal[1];
                break;
            case 3://북
                int saveBotValue = this.vertical[0];
                this.vertical[0] = this.vertical[1];
                this.vertical[1] = this.vertical[2];
                this.vertical[2] = this.vertical[3];
                this.vertical[3] = saveBotValue;
                this.horizontal[1] = this.vertical[1];
                break;
            case 4://남
                int saveTopValue = this.vertical[3];
                this.vertical[3] = this.vertical[2];
                this.vertical[2] = this.vertical[1];
                this.vertical[1] = this.vertical[0];
                this.vertical[0] = saveTopValue;
                this.horizontal[1] = this.vertical[1];
                break;
        }
    }

    void move(int directionNumber) {
        int editRow;
        int editCol;

        switch (directionNumber) {
            case 1: // 동
                editRow = this.row;
                editCol = this.col + 1;
                if (isOutOfTable(editRow, editCol)) {
                    break;
                }
                changeDiceSide(directionNumber);
                changeDiceValue(editRow, editCol);
                System.out.println(getTopSideValue());
                changeMyRowAndMyCol(editRow, editCol);
                break;
            case 2: // 서
                editRow = this.row;
                editCol = this.col - 1;
                if (isOutOfTable(editRow, editCol)) {
                    break;
                }
                changeDiceSide(directionNumber);
                changeDiceValue(editRow, editCol);
                System.out.println(getTopSideValue());
                changeMyRowAndMyCol(editRow, editCol);
                break;
            case 3: // 북
                editRow = this.row - 1;
                editCol = this.col;
                if (isOutOfTable(editRow, editCol)) {
                    break;
                }
                changeDiceSide(directionNumber);
                changeDiceValue(editRow, editCol);
                System.out.println(getTopSideValue());
                changeMyRowAndMyCol(editRow, editCol);
                break;
            case 4: // 남
                editRow = this.row + 1;
                editCol = this.col;
                if (isOutOfTable(editRow, editCol)) {
                    break;
                }
                changeDiceSide(directionNumber);
                changeDiceValue(editRow, editCol);
                System.out.println(getTopSideValue());
                changeMyRowAndMyCol(editRow, editCol);
                break;
        }
    }

    private void changeMyRowAndMyCol(int editRow, int editCol) {
        this.row = editRow;
        this.col = editCol;
    }

    private String getTopSideValue() {
        return diceSide[this.vertical[1]];
    }

    private String getBotSideValue() {
        return diceSide[this.vertical[3]];
    }

    private void setBotSideValue(String value) {
        diceSide[this.vertical[3]] = value;
    }

    private void changeDiceValue(int editRow, int editCol) {
        String mapData = this.map.get(editRow)[editCol];
        if (mapData.equals("0")) {
            this.map.get(editRow)[editCol] = String.valueOf(getBotSideValue());
        } else {
            setBotSideValue(this.map.get(editRow)[editCol]);
            this.map.get(editRow)[editCol] = "0";
        }
    }
}
