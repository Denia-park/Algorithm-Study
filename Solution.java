package com.company;

class Solution {
    public int[] solution(int[] prices) {
        //answer 선언
        int[] answer = new int[prices.length];

        //모든 요소에 대해서 완전 탐색 수행 - 2중 for문
        //시작점을 선언
        for (int i = 0; i < prices.length; i++) {
            //시작하는 값
            int startValue = prices[i];
            //count 용 변수
            int count = 0;
            //시작하는 값 다음부터 시작하는 값 과 비교하여 count를 올리고 작은 값이 나오면 break
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if(prices[j] < startValue)
                    break;
            }
            //answer에 count 삽입
            answer[i] = count;
        }

        return answer;
    }
}
