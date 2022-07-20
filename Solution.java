package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}) == 5);
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}) == 4);
        System.out.println(solution(3, new int[]{3}, new int[]{1}) == 2);
        System.out.println(solution(2, new int[]{1,2}, new int[]{1,2}) == 2);
        System.out.println(solution(3, new int[]{2}, new int[]{2,3}) == 3);
        System.out.println(solution(5, new int[]{2,4}, new int[]{3,1}) == 5);
    }

    static public int solution(int n, int[] lostArr, int[] reserveArr) {
        int answer = 0;
        //n - lost수 를 먼저 구하고 거기에 reserve 에서 체육복을 빌려줄 친구를 찾아서 더해주자.
        answer = n - lostArr.length;

        //reserve중에 lost가 있는지 확인하기.
        //확인하고 reserve를 새로 보관할 Arr 를 만들기
        int[] newReserveArr = new int[reserveArr.length];

        //정렬을 시키지 않으면 마지막 테스트 케이스에서 실패한다.
        //solution(5, new int[]{2,4}, new int[]{3,1}) == 5;
        Arrays.sort(lostArr);
        Arrays.sort(reserveArr);

        //for문을 돌면서 reserve를 확인하기
        for (int i = 0; i < reserveArr.length; i++) {
            boolean isContain = false;
            int tempJ = -1;
            for (int j = 0; j < lostArr.length; j++) {
                if(reserveArr[i] == lostArr[j]){
                    isContain = true;
                    tempJ = j;
                    break;
                }
            }
            if(isContain){
                newReserveArr[i] = -1; //newReserve에 -1을 넣어서 사용하지 못하는 값이라고 표시
                lostArr[tempJ] = -1; //Lost 값을 변경시켜서 lost를 없애자
                answer += 1; //Lost 와 reserve가 중복되면 lost를 하나 없애는것과 동일하므로 answer에 1개를 추가
            }else {
                newReserveArr[i] = reserveArr[i]; //lost에 없으면 해당 reserve는 살아있는 reserve니까 newReserveArr 에 추가
            }
        }

        //for문을 돌면서 체육복을 빌릴 수 있는지 확인하기
        for (int i = 0; i < lostArr.length; i++) {
            for (int j = 0; j < newReserveArr.length; j++) {
                //-1이 들어있으면 사용하지 못하는 값이므로 조건으로 걸었다.
                if ((lostArr[i] - 1 == newReserveArr[j] || lostArr[i] + 1 == newReserveArr[j]) && newReserveArr[j] > 0) {
                    answer += 1;
                    //체육복을 빌렸으면 빌린 친구는 체육복이 없으므로 없다고 표시하자.
                    newReserveArr[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}

