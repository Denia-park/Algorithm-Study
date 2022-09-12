package com.company;

class Solution {
    public int solution(int[] people, int limit) {
        boolean[] isMoved = new boolean[people.length];
        int peopleNum = 0;
        int moveCount = 0;

        while(peopleNum != people.length){
            int curWeight = 0;
            int curPeopleLimit = 2;
            int curMovePeopleNum = 0;

            for(int i = 0; i < people.length; i++) {
                if(!isMoved[i] && curWeight + people[i] <= limit && curMovePeopleNum <= curPeopleLimit){
                    curWeight += people[i];
                    isMoved[i] = true;
                    peopleNum++;
                    curMovePeopleNum++;
                }
            }
            moveCount++;
        }

        return moveCount;
    }

}
