package com.company;
class Solution {
    public int[] solution(String s) {
        //answer 배열 정의
        int[] answer = new int[2];

        //변환 횟수를 저장할 변수 생성
        int conversionCount = 0;
        //없앤 0의 수를 저장할 변수 생성
        int zeroCount = 0;

        //주어진 s 가 "1"이 될 때까지 루프를 반복
        while(!s.equals("1")) {
            //현재의 길이를 저장
            int curStrLength = s.length();
            //0을 공백으로 변환
            s = s.replace("0", "");
            //공백으로 변환 후 길이를 저장
            int afterStrLength = s.length();

            //2개의 길이 차이를 구하면 변환된 0의 갯수를 알 수 있음
            zeroCount += (afterStrLength - curStrLength);

            //현재 길이를 다시 2진수로 변환
            s = Integer.toBinaryString(afterStrLength);

            //변환을 할때마다 conversionCount 업데이트
            conversionCount++;
        }

        //루프가 끝나면 answer 배열을 업데이트.
        //zeroCount 는 음수가 나오기 때문에 마지막에 - 을 다시 붙여서 양수로 만든다.
        answer[0] = conversionCount;
        answer[1] = -zeroCount;

        return answer;
    }
}
