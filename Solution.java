package com.company;

import java.util.Arrays;

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
        boolean answer = true;

        //정렬 - 문자열 정렬이므로 사전순으로 정렬됨
        Arrays.sort(phone_book);

        // 사전순 정렬이면 비슷한 단어끼리 정렬이 되고
        // 길이가 짧은 문자열이 무조건 앞에 오므로
        // 앞에 있는 문자열이 뒤에 있는 문자열의 시작문자 인지 확인만 하면 된다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            if(i + 1 < phone_book.length && phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }

        return answer;
    }
}
