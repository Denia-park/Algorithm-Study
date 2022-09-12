package com.company;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int peopleNum = 0;
        int moveCount = 0;

        Arrays.sort(people);

        int limitValIndex = bisectLeft(people, limit);

        peopleNum += people.length - limitValIndex;
        moveCount += peopleNum;

        int[] newPeople = Arrays.copyOfRange(people, 0, limitValIndex);

        boolean[] isMovedNewPeople = new boolean[newPeople.length];

        int firstPersonIndex = isMovedNewPeople.length - 1;

        while(peopleNum != people.length){
            int smallValIndex = -1;
            int secondPersonIndex = 0;

            isMovedNewPeople[firstPersonIndex] = true;
            peopleNum++;

            for (secondPersonIndex = 0; secondPersonIndex < firstPersonIndex; secondPersonIndex++) {
                if (!isMovedNewPeople[secondPersonIndex] && newPeople[firstPersonIndex] + newPeople[secondPersonIndex] <= limit) {
                    smallValIndex = secondPersonIndex;
                }
            }
            
            if(smallValIndex != -1) {
                isMovedNewPeople[smallValIndex] = true;
                peopleNum++;
            }

            firstPersonIndex--;
            moveCount++;
        }

        return moveCount;
    }

    public int bisectLeft(int[] people, int targetValue) {
        int start = 0;
        int end = people.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if(targetValue <= people[mid]) {
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }
}

