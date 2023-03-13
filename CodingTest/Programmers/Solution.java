package CodingTest.Programmers;

import java.util.ArrayList;

class Solution {

    private final int START = 1;
    private final int END = 3;
    private int TOTAL_VALUE = 1 + 2 + 3;
    private ArrayList<int[]> answerList;

    public int[][] solution(int n) {
        this.answerList = new ArrayList<>();

        hanoi(n);

        return answerList.toArray(new int[0][0]);
    }

    private void hanoi(int blockNum) {
        hanoiMove(blockNum - 1, START, TOTAL_VALUE - START - END);
        hanoiMove(1, START, END);
        hanoiMove(blockNum - 1, TOTAL_VALUE - START - END, END);
    }

    private void hanoiMove(int num, int from, int to) {
        if (num == 1) {
            this.answerList.add(new int[]{from, to});
            return;
        }

        hanoiMove(num - 1, from, TOTAL_VALUE - from - to);
        hanoiMove(1, from, to);
        hanoiMove(num - 1, TOTAL_VALUE - from - to, to);
    }
}


