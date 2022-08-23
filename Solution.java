package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    //4방향 확인을 위해서 변수의 이름을 지정
    final int DIRECTION_FROM_UP = 0;
    final int DIRECTION_FROM_RIGHT = 1;
    final int DIRECTION_FROM_DOWN = 2;
    final int DIRECTION_FROM_LEFT = 3;
    //글자가 새겨진 char 배열 생성
    char[][] pathGrid;
    //만들어져야 하는 배열의 row, column 확인
    int rowsLength ;
    int columnsLength;
    //4개의 방향 값을 변수로 생성 [상 하 좌 우]
    int directionsNum = 4;
    public int[] solution(String[] grid) {
        //길이를 세고 나서 저장을 해야 하므로 List 생성
        List<Integer> answerList = new ArrayList<Integer>();
        //배열의 row, column 길이 지정
        rowsLength = grid.length;
        columnsLength = grid[0].length();

        //2차원 배열에다가 4방향 값을 추가해서 3차원 배열을 생성
        boolean[][][] pathCheckGrid = new boolean[directionsNum][rowsLength][columnsLength];

        //글자가 새겨진 2차원 배열 생성
        pathGrid = new char[rowsLength][columnsLength];

        //grid 로 부터 글자를 읽어서 pathGrid 를 채워준다.
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                pathGrid[i][j] = grid[i].charAt(j);
            }
        }

        //모든 방향에서 빛을 쏴보고 길이를 확인할 메서드
        startLight(pathCheckGrid , answerList);

        //오름차순으로 return 해야 하므로 sort
        Collections.sort(answerList);

        //Integer List 이므로 stream 을 이용하여 primitive 로 변경
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private void startLight(boolean[][][] pathCheckGrid, List<Integer> answerList) {
        //모든 원소들에 대해서 4방향에서 오는 모든 경우의 수를 고려해야함
        //3차원 배열이므로 for 문이 3번 중첩된다.
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                for (int k = 0; k < directionsNum; k++) {
                    //checkPath 에서 길이를 확인하고 return 해줄 예정
                    int pathLength = checkPath(k, i, j, pathCheckGrid);
                    //길이가 0인 것은 루트가 없는 것이므로 List 에 추가하지 않는다.
                    if(pathLength != 0)
                        answerList.add(pathLength);
                }
            }
        }

    }

    private int checkPath(int direction, int row, int column, boolean[][][] pathCheckGrid) {
        //count 를 0으로 초기화
        int count = 0;
        //changeRowPosition , changeColumnPosition 를 편하게 쓰기 위해서 MOVE_UP , MOVE_DOWN 를 지정
        boolean MOVE_UP = true;
        boolean MOVE_DOWN = false;

        boolean MATRIX_ROW = true;
        boolean MATRIX_COLUMN = false;

        //이미 방문한적이 있으면 지나간 경로이므로 바로 return
        if(pathCheckGrid[direction][row][column])
            return 0;

        //들어왔다는 건 방문했다는 뜻 , 길이를 1 증가 시킨다.
        pathCheckGrid[direction][row][column] = true;
        count++;

        //While 문을 돌면서 빛이 사이클에 포함될때까지 돈다.
        while(true){
            char pathGridChar = pathGrid[row][column];
            // 4가지 방향에 대해서 확인을 먼저 하고
            // 그리고 pathGrid 에 있는 글자를 보고 좌표 이동을 한다.
            // direction 은 어디서 온 방향인지를 확인
            // changeMatrixPosition 는 현재 좌표값을 수정
            // pathGridChar 에서 L 이나 R을 만나면 direction 을 변경해준다.
            if(direction == DIRECTION_FROM_UP){
                if (pathGridChar == 'S') {
                    row = changeMatrixPosition(row, MOVE_UP, MATRIX_ROW);
                } else if (pathGridChar == 'L') {
                    column = changeMatrixPosition(column, MOVE_UP, MATRIX_COLUMN);
                    direction = DIRECTION_FROM_LEFT;
                } else if (pathGridChar == 'R') {
                    column = changeMatrixPosition(column, MOVE_DOWN, MATRIX_COLUMN);
                    direction = DIRECTION_FROM_RIGHT;
                }
            }
            else if(direction == DIRECTION_FROM_RIGHT){
                if (pathGridChar == 'S') {
                    column = changeMatrixPosition(column, MOVE_DOWN, MATRIX_COLUMN);
                } else if (pathGridChar == 'L') {
                    row = changeMatrixPosition(row, MOVE_UP, MATRIX_ROW);
                    direction = DIRECTION_FROM_UP;
                } else if (pathGridChar == 'R') {
                    row = changeMatrixPosition(row, MOVE_DOWN, MATRIX_ROW);
                    direction = DIRECTION_FROM_DOWN;
                }
            }
            else if(direction == DIRECTION_FROM_DOWN){
                if (pathGridChar == 'S') {
                    row = changeMatrixPosition(row, MOVE_DOWN, MATRIX_ROW);
                } else if (pathGridChar == 'L') {
                    column = changeMatrixPosition(column, MOVE_DOWN, MATRIX_COLUMN);
                    direction = DIRECTION_FROM_RIGHT;
                } else if (pathGridChar == 'R') {
                    column = changeMatrixPosition(column, MOVE_UP, MATRIX_COLUMN);
                    direction = DIRECTION_FROM_LEFT;
                }
            }
            else if(direction == DIRECTION_FROM_LEFT){
                if (pathGridChar == 'S') {
                    column = changeMatrixPosition(column, MOVE_UP, MATRIX_COLUMN);
                } else if (pathGridChar == 'L') {
                    row = changeMatrixPosition(row, MOVE_DOWN, MATRIX_ROW);
                    direction = DIRECTION_FROM_DOWN;
                } else if (pathGridChar == 'R') {
                    row = changeMatrixPosition(row, MOVE_UP, MATRIX_ROW);
                    direction = DIRECTION_FROM_UP;
                }
            }

            // 변경된 좌표의 boolean 값을 변경
            // 그리고 count 도 + 1 해준다.
            if(!pathCheckGrid[direction][row][column]){
                pathCheckGrid[direction][row][column] = true;
                count ++;
            }
            else
                break;
        }

        return count;
    }

    private int changeMatrixPosition(int positionIndex, boolean upOrDown, boolean rowOrColumn) {
        int rowStartIndex = 0;
        int rowEndIndex = rowsLength - 1;
        int columnStartIndex = 0;
        int columnEndIndex = columnsLength - 1;
        //Up
        if(upOrDown) {
            //row
            if (rowOrColumn) {
                if(positionIndex < rowEndIndex)
                    positionIndex += 1;
                else
                    positionIndex = rowStartIndex;
            }
            //Column
            else{
                if(positionIndex < columnEndIndex)
                    positionIndex += 1;
                else
                    positionIndex = columnStartIndex;
            }
        }
        //Down
        else {
            //row
            if (rowOrColumn) {
                if(positionIndex > rowStartIndex)
                    positionIndex -= 1;
                else
                    positionIndex = rowEndIndex;
            }
            //Column
            else{
                if(positionIndex > columnStartIndex)
                    positionIndex -= 1;
                else
                    positionIndex = columnEndIndex;
            }
        }

        return positionIndex;
    }
}
