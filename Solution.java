package com.company;

class Solution {
    char[] quizCharArr;
    int curIndex;
    int answer;
    public int solution(String quizString) {
        int strLen = quizString.length();
        String answerString = "";

        curIndex = strLen-1;
        answer = 0;
        quizCharArr = quizString.toCharArray();

        for (int i = 0; i < strLen; i++)
            answerString += "A";

        while (!String.valueOf(quizCharArr).equals(answerString)) {
            if(quizCharArr[curIndex] == 'A'){
                curIndex = findNextIndex();
            }else{
                changeCurCharToA();
            }
        }

        return answer;
    }

    private void changeCurCharToA() {
        answer += Math.min((quizCharArr[curIndex] - 'A'), ('Z' + 1) - quizCharArr[curIndex]);
        quizCharArr[curIndex] = 'A';
    }
    private int findNextIndex() {
        int plusAmount = 0;
        boolean plusGetFlag = false;
        int minusAmount = 0;
        boolean minusGetFlag = false;

        //현재 인덱스에서 양수로 옮기면서 A 아닌 값을 확인
        for (int i = curIndex ; i < quizCharArr.length; i++) {
            if(quizCharArr[i] != 'A'){
                plusGetFlag = true;
                break;
            }
            plusAmount ++;
        }
        if(!plusGetFlag){
            for (int i = 0; i < curIndex; i++) {
                if(quizCharArr[i] != 'A'){
                    break;
                }
                plusAmount ++;
            }
        }

        //현재 인덱스에서 음수로 옮기면서 A 아닌 값을  확인
        for (int i = curIndex; i >= 0; i--) {
            if(quizCharArr[i] != 'A'){
                plusGetFlag = true;
                break;
            }
            minusAmount++;
        }
        if(!minusGetFlag){
            for (int i = quizCharArr.length - 1; i > curIndex; i--) {
                if(quizCharArr[i] != 'A'){
                    break;
                }
                minusAmount++;
            }
        }

        if(plusAmount <= minusAmount){
            answer += plusAmount;
            return (curIndex + plusAmount) % quizCharArr.length;
        }
        else{
            answer += minusAmount;
            return (curIndex + quizCharArr.length - minusAmount) % quizCharArr.length;
        }
    }
}
