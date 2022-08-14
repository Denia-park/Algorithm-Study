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

        System.out.println(testSolution.solution(strA1, strB1));
        System.out.println(testSolution.solution(strA2, strB2));
        System.out.println(testSolution.solution(strA3, strB3));
        System.out.println(testSolution.solution(strA4, strB4));
        System.out.println(testSolution.solution("abc   ", " abbb")); //TestCase 7 9 10 11 풀이
        System.out.println(testSolution.solution("ab   ", " bbbb")); //TestCase 7 9 10 11 풀이
    }

    public int solution(String str1, String str2) {
        //문자열을 쪼개진 문자열 배열로 나눈다.
        String[] splitStringArr1 = splitString(str1);
        String[] splitStringArr2 = splitString(str2);

        //유사도 계산 메서드
        double similarityOfTwoString = caculateSimilarity(splitStringArr1, splitStringArr2);

        // 유사도가 0에서 1 사이의 실수이므로,
        // 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력
        return (int) Math.floor(similarityOfTwoString * 65536);
    }

    private double caculateSimilarity(String[] splitStringArr1, String[] splitStringArr2) {
        //둘 다 공집합이면 유사도는 1
        if(splitStringArr1.length == 0 && splitStringArr2.length == 0)
            return 1;

        double unionLength = 0;
        double intersectionLength = 0;

        //배열에서 각 원소들의 개수를 카운팅하기 위해 Map을 생성
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();

        //배열에서 각 원소들의 개수를 카운팅
        for (String splitString : splitStringArr1) {
            map1.put(splitString, map1.getOrDefault(splitString, 0) + 1);
        }
        //배열에서 각 원소들의 개수를 카운팅
        for (String splitString : splitStringArr2) {
            map2.put(splitString, map2.getOrDefault(splitString, 0) + 1);
        }

        //교집합의 수을 계산 , map1을 쓰던 map2를 쓰던 상관이 없다.
        //공통된 Key를 찾고 그 Key의 Value 중에서 작은 값을 교집합으로 사용한다.
        //교집합이 여러개 있을 수 있으므로 교집합의 수는 기존값에서 계속해서 더한다.
        for (String mapKey : map1.keySet()) {
            if(map2.containsKey(mapKey)){
                intersectionLength += Math.min(map1.get(mapKey), map2.get(mapKey));
            }
        }

        //합집합은 2개의 배열의 원소 수를 더한 다음에 교집합의 원소의 수 만큼 빼주면 된다.
        //집합의 규칙 사용
        unionLength = splitStringArr1.length + splitStringArr2.length - intersectionLength;

        //returnValue 는 교집합 원소 수 / 합집합 원소 수
        return intersectionLength / unionLength;
    }

    //글자 나눠주는 메서드
        //특징
        //1. 글자를 나눈다
        //2. 특수문자가 들어있으면 없앤다.
        //3. 모두 소문자로 변경한다.
    private String[] splitString(String str) {
        //문자열을 저장할 List
        List<String> answer = new ArrayList<>();

        //문자열 길이의 -1 만큼 까지 for문을 돌리면 된다.
        for (int i = 0; i < (str.length() - 1); i++) {
            //i를 계속해서 올려가며 substring을 통해 문자열을 쪼개고 toLowerCase를 통해 소문자로 만든다.
            String tempStr = str.substring(i, i + 2).toLowerCase();

            //만들어진 문자열 중에 첫번째 문자 혹은 두번째 문자가 알파벳이 아닌 경우는 List에 넣지 않는다.
            if(!Character.isLowerCase(tempStr.charAt(0)) || !Character.isLowerCase(tempStr.charAt(1)))
                continue;

            //조건에 해당하는 문자열을 List에 추가
            answer.add(tempStr);
        }

        //List를 배열로 만들어서 return한다.
        return answer.toArray(new String[0]);
    }
}
