package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        //옷의 종류 [String] 와 옷의 개수 [Integer] 를 묶어서 저장하기 위해서 HashMap을 사용
        Map<String, Integer> map = new HashMap<String, Integer>();

        //clothes를 for-each 사용해서 String[] 로 나눠서 코드 적용
        //1번째 요소는 옷의 종류
        //0번째 요소는 옷의 이름 [※같은 이름을 가진 의상은 존재하지 않습니다.]
        for (String[] clothe : clothes) {
            //옷의 종류를 type으로 지정
            String type = clothe[1];
            //type을 map에 넣고 getOrDefault 를 사용해서 갯수를 세서 집어넣는다.
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        //스파이는 옷을 서로 다르게 조합으로 입어야 하므로
        //(옷의 종류에 따른 의상의 수 + 1(안입는 경우)) 를 옷의 종류만큼 서로 곱해주고,
        //무조건 한개의 의상은 입어야 하므로 마지막에 모두 벗은 경우를 고려하여 -1 해주면 답이 나온다.

        // 예를 들면 다음과 같다.
        // 옷이 다음과 같이 있을때
        // [얼굴: 2개,  상의: 1개, 하의 : 1개,  겉옷 : 1개]
            //얼굴 기준 : 안 입는다 / 1번 의류 입는다 / 2번 의류 입는다. => 경우의수 : 3개
            //상의 기준 : 안 입는다 / 1번 의류 입는다  => 경우의수 : 2개
            //하의 기준 : 안 입는다 / 1번 의류 입는다  => 경우의수 : 2개
            //겉옷 기준 : 안 입는다 / 1번 의류 입는다  => 경우의수 : 2개
        // 3개 * 2개 * 2개 * 2개 => 24개
        // 근데 여기서 모두 안입는 경우는 빼줘야 하므로 -1을 뺀다
        // 정답은 23개

        //곱셈에 필요한 초기값은 1
        int tempMultiply = 1;

        //map의 values를 탐색하면서 (num + 1) 을 tempMultiply에 계속해서 곱해준다.
        for (Integer num : map.values()) {
             tempMultiply *= (num+1);
        }

        //tempMultiply에서 모두 벗은 경우를 1개 빼면 답이 된다.
        return (tempMultiply - 1);
    }
}
