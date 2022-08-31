package com.company;

// 출처 : https://cyk0825.tistory.com/35

class Solution {
    public String solution(String number, int k) {
        //문자열을 합해야 하므로 StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        //시작 index를 저장하기 위해 변수 생성
        int startIndex = 0;

        /*
         * 주어진 숫자 n에서 k개의 숫자를 빼서 가장 큰 수를 찾아라
         * n의 자릿 수 - k = 가장 큰 수의 길이
         *
         * 가장 큰 수의 첫번째 자리에 올 수 있는 수는 n에서 인덱스가 0~k까지
         * 두번째 자리에 올 수 있는 수는 n에서 인데스가 1~k+1에 해당하는 수
         * 세번째 자리에 올 수 있는 수는 n에서 인데스가 2~k+2에 해당하는 수 ...
         * 이런식으로 해당 자리에 오는 수 중 가장 큰 수를 하나씩 찾는데 그 전수 보다 앞자리에 올 수 는 없기 때문에
         * 마지막으로 찾은 자리 수의 인덱스 +1부터 자리에 올 수 있는 가장 마지막 수의 인덱스 까지 비교하며 찾는다.
        */

        //for문을 돌면서 확인을 해야함
        for (int i = 0; i < number.length() - k; i++) {
            int maxValue = Integer.MIN_VALUE;
            for (int j = startIndex; j <= i + k ; j++) {
                int tempChar = number.charAt(j) - '0';
                if(tempChar > maxValue){
                    maxValue = tempChar;
                    startIndex = j + 1;
                }
            }

            sb.append(maxValue);
        }

        return sb.toString();
    }
}
