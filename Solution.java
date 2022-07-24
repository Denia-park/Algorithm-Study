package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println((Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))));
        System.out.println((Arrays.toString(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}))));
    }

    static public String[] solution(int n, int[] arr1, int[] arr2) {
        // 0. 한변의 길이가 n인 정사각형 배열
        // 1. 문제를 보면 암호를 해독하기 위해서는 10진수를 2진수로 바꿔야함 (지도 1 과 지도 22 는 각각 정수 배열로 암호화)
        // 2. 조건을 보면 두 장의 지도를 겹쳐서 얻을 수 있다. 그리고 두 장의 지도 중 한 곳에서 벽이면 무조건 벽 , 한 곳이 공백은 무조건 공백
        // 이므로 2진수로 변경하고 비트연산 OR을 사용하면 된다는 것을 알 수 있다.
        // 3. 벽은 1 ("#"), 공백은 0 (" ")

        // answer용 Array
        String[] answer = new String[n];

        // arr1 과 arr2를 비트연산 OR 해서 담아둘 Array
        String[] totalArr1OrArr2 = new String[n];

        // 암호 해독을 위해서 변환하는 과정 (10진수를 2진수로 변경하기)
        for (int i = 0; i < n; i++) {
            //2진수로 바꿔서 비트연산 OR 하는거 대신에 비트연산 OR을 먼저해서 2진수로 바꾸기
            String mixMapArrElements = Integer.toBinaryString(arr1[i] | arr2[i]);

            //앞자리에 0이 있는 애들은 toBinaryString 를 쓰면 해당 칸이 없게 나오므로 앞에 0을 강제로 붙여줘야함
            StringBuilder sb = new StringBuilder(mixMapArrElements);
            for (int j = 0 ; j < (n - mixMapArrElements.length()); j++) {
                sb.insert(0,"0");
            }
            // 0을 붙여준 String 을 저장한다.
            totalArr1OrArr2[i] = sb.toString();
        }

//        System.out.println(Arrays.deepToString(totalArr1OrArr2));

        // 암호화 풀기 (2진수를 "#" 및 " "으로 변경)
        for (int i = 0; i < n; i++) {
            //0은 공백으로 , 1은 #으로 변경하기.
            answer[i] = totalArr1OrArr2[i].replace('0', ' ').replace('1', '#');
        }

        return answer;
    }
}

