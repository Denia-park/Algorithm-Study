package com.company;

import java.util.*;

public class Solution {
    static public void main(String[] args) {
        String strA1 = "FRANCE";
        String strB1 = "french";
        String strA2 = "handshake";
        String strB2 = "shake hands";
        String strA3 = "aa1+aa2";
        String strB3 = "AAAA12";
        String strA4 = "E=M*C^2";
        String strB4 = "e=m*c^2";


        Solution testSolution = new Solution();

//        System.out.println(testSolution.solution(strA1, strB1));
//        System.out.println(testSolution.solution(strA2, strB2));
//        System.out.println(testSolution.solution(strA3, strB3));
//        System.out.println(testSolution.solution(strA4, strB4));
        System.out.println(testSolution.solution("abc   ", " abbb"));
        System.out.println(testSolution.solution("ab   ", " bbbb"));
    }

    public int solution(String str1, String str2) {
        String[] splitStringArr1 = splitString(str1);
        System.out.println(Arrays.toString(splitStringArr1));
        String[] splitStringArr2 = splitString(str2);
        System.out.println(Arrays.toString(splitStringArr2));

        //유사도 계산 메서드
        double similarityOfTwoString = caculateSimilarity(splitStringArr1, splitStringArr2);

        return (int) Math.floor(similarityOfTwoString * 65536);
    }

    private double caculateSimilarity(String[] splitStringArr1, String[] splitStringArr2) {
        //둘 다 공집합이면 유사도는 1
        if(splitStringArr1.length == 0 && splitStringArr2.length == 0)
            return 1;

        double unionLength = 0;
        double intersectionLength = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String splitString : splitStringArr1) {
            map.put(splitString, map.getOrDefault(splitString, 0) + 1);
        }
        for (String splitString : splitStringArr2) {
            map.put(splitString, map.getOrDefault(splitString, 0) + 1);
        }

        //두개의 배열 원소가 1개의 종류뿐일때는 두개의 원소 중 길이가 작은게 교집합의 길이 , 길이가 큰게 합집합의 길이 이다.
        if(map.size() == 1){
            return Math.min(splitStringArr1.length,splitStringArr2.length)*1.0d / Math.max(splitStringArr1.length,splitStringArr2.length);
        }

        //합집합
            //홀수 : 절반 + 1
            //짝수 : 절반
        //교집합
            //홀수(1이 아닐 때) , 짝수 : 절반
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            int entryValue = stringIntegerEntry.getValue();
            int tempValue = entryValue / 2;

            if(entryValue % 2 == 0){ //짝수
                unionLength +=  tempValue;
                intersectionLength +=  tempValue;
            }else { //홀수
                unionLength +=  tempValue + 1;

                if(entryValue != 1)
                    intersectionLength +=  tempValue;
            }
        }

        System.out.println(intersectionLength + " " + unionLength + "");

        return intersectionLength / unionLength;
    }

    //글자 나눠주는 메서드
        //특징
        //1. 글자를 나눈다
        //2. 특수문자가 들어있으면 없앤다.
        //3. 모두 소문자로 변경한다.
    private String[] splitString(String str) {
        int length = str.length() - 1;
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String tempStr = str.substring(i, i + 2).toLowerCase();

            if(!Character.isLowerCase(tempStr.charAt(0)) || !Character.isLowerCase(tempStr.charAt(1)))
                continue;

            answer.add(tempStr);
        }

        return answer.toArray(new String[0]);
    }
}
