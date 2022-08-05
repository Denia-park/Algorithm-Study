package com.company.Greedy;

// 모험가 길드 문제

import java.util.Arrays;

public class Greedy3 {
    public static void main(String[] args) {
        System.out.println(solve(5,"2 3 1 2 2"));
    }

    private static long solve(int n , String str){
        int answer = 0;
        String[] strArray = new String[n]; //문자열 배열
        strArray = str.split(" ");

        int[] intArray = new int[n]; //정수 배열

        //인덱스
        int index = 0;
        
        //정수 배열 내용 업데이트
        for (String tempStr : strArray) {
            intArray[index] = (Integer.parseInt(tempStr));
            index++;
        }

        //오름차순 정리
        Arrays.sort(intArray);

        //현재 그룹에 포함된 모험가의 수
        int member = 0;
        //공포도가 낮은 사람부터 하나씩 확인하며
        for (int peer : intArray) {
            //현재 그룹에 해당 모험가를 포함시키기
            member += 1;

            //현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면 , 그룹 결성
            if(peer <= member){
                //그룹 결성
                answer = answer + 1;
                //모험가의 수 초기화
                member = 0;
            }
        }

        return answer;
    }
}
