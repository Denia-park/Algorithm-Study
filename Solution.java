package com.company;

import java.util.*;

class Solution {
    static public void main(String[] args){
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        System.out.println(solution(participant, completion));
    }

    static public String solution(String[] participants, String[] completions) {
        //이름으로 된 데이터들을 비교하기 위해서 Map을 사용함
        Map<String, Integer> diffMap = new HashMap<>();

        //참가자들의 기본 데이터를 삽입 <이름, 기본 값 + 1>
        for (String participant : participants) {
            diffMap.put(participant, diffMap.getOrDefault(participant, 0) + 1);
        }

        //완주자들은 +1 해줬던 값을 다시 뺀다.
        for (String completion : completions) {
            diffMap.put(completion, diffMap.get(completion) - 1);
        }

        //get 값이 0이 아닌 참가자가 완주하지 못한 참가자
        for(String participant : participants) {
            if(diffMap.get(participant) > 0 ){
                return participant;
            }
        }

        return null ;
    }
}