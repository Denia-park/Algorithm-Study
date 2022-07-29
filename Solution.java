package com.company;

public class Solution {
    static public void main(String[] args) {

        System.out.println(solution("aabbaccc")); //2a2ba3c

    }

    static public int solution(String s) {
        //처음에 받아온 글자 수보다는 무조건 작어져야 하니까,
        // 처음에는 그냥 받아온 문자열의 글자수를 넣는다.
        int answer = s.length();
        //압축한 String을 담아둘 변수
        StringBuilder compressString= new StringBuilder();
        //동일 글자를 판단하고 몇번 중복됐는지 담아둘 변수, 잘랐다는 것은 1번은 있다는 소리니까 1을 넣는다.
        int repeatCharNumber = 1;
        //처음에는 1글자씩 쪼개는 것으로 시작
        int charNumCount = 1;
        //for문을 위한 Index
        int forIndex = 0;

        //그리디 방식으로 진행을 해야할 것 같다.
            //while 문안에 for문을 구현하는 방식.
        while (charNumCount < s.length()) {
            System.out.println("쪼개는 글자수 : " + charNumCount);
            System.out.println("시작하는 Index : " + forIndex);

            //임시 String
            String tempString= s.substring(forIndex,forIndex + charNumCount);
            //반복되는 글자 수 초기화
            repeatCharNumber = 1;

            for (; forIndex < s.length(); forIndex++) {
                if (tempString.equals(s.substring(forIndex, forIndex + charNumCount))) {
                    repeatCharNumber++;
                }else{
                    compressString.append(repeatCharNumber).append(tempString);
                    break;
                }
            }

            charNumCount++;
        }

        System.out.println(compressString.toString());
        return answer;
    }
}
