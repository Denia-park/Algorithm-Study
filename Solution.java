package com.company;

import java.util.*;

public class Solution {
    static public void main(String[] args) {
        String quiz1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}"	;
        String quiz2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"	;
        String quiz3 = "{{20,111},{111}}";
        String quiz4 = "{{123}}";
        String quiz5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";


        System.out.println(Arrays.toString(solution(quiz1)));
        System.out.println(Arrays.toString(solution(quiz2)));
        System.out.println(Arrays.toString(solution(quiz3)));
        System.out.println(Arrays.toString(solution(quiz4)));
        System.out.println(Arrays.toString(solution(quiz5)));
    }

    static public Integer[] solution(String s) {
        Integer[] answer = {};
        //Set 자료 구조 사용 - 등록한 순서를 유지하기 위해서 LinkedHashSet를 사용함
        Set<Integer> set = new LinkedHashSet<>();

        //브라켓 지우고 String 리턴
        String deletedBracketString = getDeletedBracketString(s);

        //중간에 문자열을 화이트 스페이스로 교체 후 화이트 스페이스 기준으로 split
        String[] strArray = deletedBracketString.replace("},{"," ").split(" ");

        //문자열 길이를 기준으로 Sort
        Arrays.sort(strArray,new MyComparator());

        //짧은 문자열을 기준으로 내부 원소들을 Set에 하나씩 추가
        for (String str : strArray) {
            //strArray에서 str을 받아오면 ,로 원소들이 묶여있어서 ","를 기준으로 분해 후 하나씩 추가해줄 것
            //문자열 짧은 "튜플"이 처음부터 있는 원소이기 때문에 개네들을 먼저 추가해줘야함
            //먼저 추가해준 애들은 뒤에 또 추가해줘도 Set 자료형 이기 때문에 문제가 없다
            for(String str2: str.split(",")){
                set.add(Integer.parseInt(str2));
            }
        }

        return set.toArray(answer);
    }

    //브라켓 지워지는 메서드
    private static String getDeletedBracketString(String str) {
        return str.substring(2,str.length()-2);
    }
}

//Comparator 구현 : String 의 길이를 비교해서 짧은 것을 앞에 오도록 배치
class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //String 의 길이를 비교해서 짧은 것을 앞에 오도록 배치
        if(o1.length() < o2.length())
            return -1;

        return 1;
    }
}

