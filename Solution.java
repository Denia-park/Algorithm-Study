package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(String[] grid) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<Integer>();
        int rowsLength = grid.length;
        int columnsLength = grid[0].length();
        int directionsNum = 4; //상 우 하 좌

        boolean[][][] pathCheckGrid = new boolean[directionsNum][rowsLength][columnsLength];

        char[][] pathGrid = new char[rowsLength][columnsLength];

        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                pathGrid[i][j] = grid[i].charAt(j);
            }
        }

        //12
        for (int i = 0; i < rowsLength; i++) {

        }
        //3
        for (int i = 0; i < rowsLength; i++) {

        }
        //6
        for (int i = 0; i < rowsLength; i++) {

        }
        //9
        for (int i = 0; i < rowsLength; i++) {

        }

        Collections.sort(answerList);

        //오름차순으로 정렬 해야함
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
