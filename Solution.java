package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] gPeople;
    int gLimit;
    int gAnswer;
    boolean[] isVisited;
    public int solution(int[] people, int limit) {
        gAnswer = Integer.MAX_VALUE;
        gPeople = people;
        gLimit = limit;
        isVisited = new boolean[people.length];
        int peopleNum = 0;
        int moveCount = 0;
        dfs(peopleNum, moveCount);
        return gAnswer;
    }

    private void dfs(int preMovePeopleNum , int preMoveCount) {
        if(preMovePeopleNum == gPeople.length){
            gAnswer = Math.min(gAnswer, preMoveCount);
        }

        int curWeight = 0;

        List<Integer> movePeopleList = new ArrayList<Integer>();

        for (int i = 0; i < gPeople.length; i++) {
            if(!isVisited[i]){
                if (curWeight + gPeople[i] <= gLimit) {
                    curWeight += gPeople[i];
                    isVisited[i] = true;
                    preMovePeopleNum++;

                    movePeopleList.add(i);
                }else{
                    preMoveCount++;
                    dfs(preMovePeopleNum, preMoveCount);
                    for (Integer integer : movePeopleList) {
                        isVisited[integer] = false;
                    }
                }
            }
        }

    }
}
