package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    final int DIRECTION_FROM_UP = 0;
    final int DIRECTION_FROM_RIGHT = 1;
    final int DIRECTION_FROM_DOWN = 2;
    final int DIRECTION_FROM_LEFT = 3;
    char[][] pathGrid;
    int rowsLength ;
    int columnsLength;
    int directionsNum ;
    public int[] solution(String[] grid) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        rowsLength = grid.length;
        columnsLength = grid[0].length();
        directionsNum = 4; //상 우 하 좌

        boolean[][][] pathCheckGrid = new boolean[directionsNum][rowsLength][columnsLength];

        pathGrid = new char[rowsLength][columnsLength];

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                pathGrid[i][j] = grid[i].charAt(j);
            }
        }

        startLight(pathCheckGrid , answerList);

        Collections.sort(answerList);

        //오름차순으로 정렬 해야함
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private void startLight(boolean[][][] pathCheckGrid, List<Integer> answerList) {
        //모든 요소에 대해서 4방향에서 오는 모든 경우의 수를 고려해야함
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                for (int k = 0; k < directionsNum; k++) {
                    int pathLength = checkPath(k, i, j, pathCheckGrid);
                    if(pathLength != 0)
                        answerList.add(pathLength);
                }
            }
        }

    }

    private int checkPath(int direction, int row, int column, boolean[][][] pathCheckGrid) {
        int count = 1;
        boolean MOVE_UP = true;
        boolean MOVE_DOWN = false;


        //이미 방문한적이 있으면 지나간 경로이므로 바로 return
        if(pathCheckGrid[direction][row][column])
            return 0;

        //들어왔다는 건 방문했다는 뜻
        pathCheckGrid[direction][row][column] = true;

        while(true){
            //여기서는 일단 좌표 이동
            if(direction == DIRECTION_FROM_UP){
                if (pathGrid[row][column] == 'S') {
                    row = changeRowPosition(row, MOVE_UP);
                } else if (pathGrid[row][column] == 'L') {
                    column = changeColumnPosition(column, MOVE_UP);
                    direction = DIRECTION_FROM_LEFT;
                } else if (pathGrid[row][column] == 'R') {
                    column = changeColumnPosition(column, MOVE_DOWN);
                    direction = DIRECTION_FROM_RIGHT;
                }
            }
            else if(direction == DIRECTION_FROM_RIGHT){
                if (pathGrid[row][column] == 'S') {
                    column = changeColumnPosition(column, MOVE_DOWN);
                } else if (pathGrid[row][column] == 'L') {
                    row = changeRowPosition(row, MOVE_UP);
                    direction = DIRECTION_FROM_UP;
                } else if (pathGrid[row][column] == 'R') {
                    row = changeRowPosition(row, MOVE_DOWN);
                    direction = DIRECTION_FROM_DOWN;
                }
            }
            else if(direction == DIRECTION_FROM_DOWN){
                if (pathGrid[row][column] == 'S') {
                    row = changeRowPosition(row, MOVE_DOWN);
                } else if (pathGrid[row][column] == 'L') {
                    column = changeColumnPosition(column, MOVE_DOWN);
                    direction = DIRECTION_FROM_RIGHT;
                } else if (pathGrid[row][column] == 'R') {
                    column = changeColumnPosition(column, MOVE_UP);
                    direction = DIRECTION_FROM_LEFT;
                }
            }
            else if(direction == DIRECTION_FROM_LEFT){
                if (pathGrid[row][column] == 'S') {
                    column = changeColumnPosition(column, MOVE_UP);
                } else if (pathGrid[row][column] == 'L') {
                    row = changeRowPosition(row, MOVE_DOWN);
                    direction = DIRECTION_FROM_DOWN;
                } else if (pathGrid[row][column] == 'R') {
                    row = changeRowPosition(row, MOVE_UP);
                    direction = DIRECTION_FROM_UP;
                }
            }

            //여기서 좌표의 boolean 값 변경
            if(!pathCheckGrid[direction][row][column]){
                pathCheckGrid[direction][row][column] = true;
                count ++;
            }
            else
                break;
        }

        return count;
    }

    private int changeRowPosition(int row, boolean upOrDown) {
        int rowStartIndex = 0;
        int rowEndIndex = rowsLength - 1;

        //Up
        if(upOrDown) {
            if(row < rowEndIndex)
                row += 1;
            else
                row = rowStartIndex;
        }
        //Down
        else {
            if(row > rowStartIndex)
                row -= 1;
            else
                row = rowEndIndex;
        }

        return row;
    }

    private int changeColumnPosition(int column, boolean upOrDown) {
        int columnStartIndex = 0;
        int columnEndIndex = columnsLength - 1;

        //Up
        if(upOrDown) {
            if(column < columnEndIndex)
                column += 1;
            else
                column = columnStartIndex;
        }
        //Down
        else {
            if(column > columnStartIndex)
                column -= 1;
            else
                column = columnEndIndex;
        }

        return column;
    }
}
