package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        String[] quizArr1 = {"119", "97674223", "1195524421"};
        String[] quizArr2 = {"123", "456", "789"};
        String[] quizArr3 = {"12", "123", "1235", "567", "88"};
        String[] quizArr4 = {"115524421", "119", "1197674223", "1234", "1235", "456", "567", "789", "88"};

        System.out.println(testSolution.solution(quizArr1));
        System.out.println(testSolution.solution(quizArr2));
        System.out.println(testSolution.solution(quizArr3));
        System.out.println(testSolution.solution(quizArr4));

    }

    public boolean solution(String[] phone_book) {
        // 해쉬를 사용한 방법 - HashSet 에 모든 phone_book 데이터를 넣는다.
        Set<String> set = new HashSet<String>(Arrays.asList(phone_book));

        //phone_book 데이터 하나씩 꺼내서 substring 으로 글자를 쪼개면서
        //쪼갠 글자가 HashSet 안에 있는지 확인한다. 있으면 return false
        //이렇게 해도 시간이 짧게 걸리는 이유는 ?
            // Hash를 사용할 경우 삽입, 검색 의 시간 복잡도가 O(1) 이기 때문에 가능
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if(set.contains(phone.substring(0, i))) return false;
            }
        }

        return true;
    }
}
