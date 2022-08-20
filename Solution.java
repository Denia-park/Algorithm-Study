package com.company;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        Integer[] numbersInt = new Integer[numbers.length];

        Arrays.setAll(numbersInt , index -> numbers[index]);

        Arrays.sort(numbersInt, new MyComparator());

        for (Integer i : numbersInt) {
            answer.append(i);
        }
        return answer.toString();
    }

    //앞자리 수가 큰게 맨 앞으로 와야함
    //총 자리수가 작은게 먼저 앞으로 와야함
    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            int tempA = a;
            int tempB = b;
            int aLen = String.valueOf(tempA).length();
            int bLen = String.valueOf(tempB).length();
            int aDivideNum = (int) Math.pow(10,aLen-1);
            int bDivideNum = (int) Math.pow(10,bLen-1);
            int aFirstNum = a / (int) Math.pow(10,aLen-1);
            int bFirstNum = b / (int) Math.pow(10,bLen-1);
            if(aLen == bLen){
                if(tempA>tempB) return -1;
            }else{
                for (int i = 0; i < Math.max(aLen,bLen); i++) {
                    if(tempA != 0 && tempB != 0){
                        if((tempA / aDivideNum) > (tempB / bDivideNum)){
                            return -1;
                        }
                        tempA %= aDivideNum;
                        tempB %= bDivideNum;
                        aDivideNum /= 10;
                        bDivideNum /= 10;
                    }else{
                        if(aDivideNum == 0){
                            int bRestNum = tempB / bDivideNum;
                            if(aFirstNum > bRestNum) return -1;
                            else return 1;
                        }else{ //aDivideNum == 0
                            int aRestNum = tempA / aDivideNum;
                            if(aRestNum < bFirstNum) return 1;
                            else return -1;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
