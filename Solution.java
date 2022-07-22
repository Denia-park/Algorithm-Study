package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println((solution(new int[]{1,3,2,5,4} , 9))==3);
        System.out.println((solution(new int[]{2,2,3,3} , 10))==4);
    }

    static public int solution(int[] d, int budgetLimit) {
        int answer = 0;
        int sumValue = 0;

        //오름차순 크기로 정렬
        Arrays.sort(d);

        //부서에서 요청한 금액을 처음부터 1개씩 더하면서 예산을 넘나 안넘나 확인
        for (int wantBudget : d) {
            //sumValue에 부서에서 요청한 값을 1개씩 더함
            sumValue = sumValue + wantBudget;
            //더한 값이 예산기준을 넘지 않았으면 answer를 +1개
            //넘었으면 break 걸어서 for문을 나가고 answer를 return
            if (sumValue <= budgetLimit) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}

