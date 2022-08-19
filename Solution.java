package com.company;

import java.util.*;

class Solution {
    // 점수를 구할때 사용할 점수 Array
    int[] scoreList = {3, 2, 1, 0, 1, 2, 3};
    // 지표에서 성격유형을 확인할 성격유형을 모아둔 String
    String indexString = "RTCFJMAN";
    public String solution(String[] survey, int[] choices) {
        //성격유형을 구해서 더해줄 answer를 공백 String으로 생성
        String answer = "";

        //String 을 Integer 와 결부시켜서 관리해야 하므로 Map을 생성함
            //성격유형과 점수를 같이 관리해야함
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        //나중에 NullPointerException 이 뜨지않게 처음에 모든 성격유형을 다 집어넣는다.
        for (int i = 0; i < indexString.length(); i++) {
            map.put(indexString.charAt(i), 0);
        }

        //survey Array 를 돌면서 점수 를 성격유형에 맞게 추가해준다.
        for (int i = 0; i < survey.length; i++) {
            //어떤 성격유형인지 charAt 으로 구분
            char char0 = survey[i].charAt(0);
            char char1 = survey[i].charAt(1);

            //몇번 선택지를 선택했는지 확인
            int selectNum = choices[i];
            //선택지에 따른 점수를 확인 (1번 지표가 0번 Index 이기 때문에 -1을 해줘야한다.)
            int selectScore = scoreList[selectNum - 1];

            //1~3번은 첫번째 성격유형
            //4번은 둘 다 0점 이므로 코드에 추가 X
            //5~7번은 두번째 성격유형
            if (selectNum < 4)
                map.put(char0, map.get(char0) + selectScore);
            else if(selectNum > 4)
                map.put(char1, map.get(char1) + selectScore);
        }

        // indexString 을 기준으로 모든 성격유형 짝을 확인하고
        // 성격유형이 가진 값을 확인하여 answer 에 성격유형을 추가함
            // 2개씩 묶어서 처리해야 하므로 i는 2씩 더해줘야함.
        for (int i = 0; i < indexString.length(); i += 2) {
            //성격유형 짝에서 첫번째 성격유형 과 두번째 성격유형을 구한다.
            char index0 = indexString.charAt(i);
            char index1 = indexString.charAt(i + 1);

            //두개의 성격유형이 값이 같지 않고 , 두번째 성격유형의 점수가 높다면 두번째 성격유형을 추가
            //그게 아니라면 무조건 첫번째 성격유형을 추가한다.
            if (!Objects.equals(map.get(index0), map.get(index1)) && map.get(index0) < map.get(index1))
                answer += String.valueOf(index1);
            else
                answer += String.valueOf(index0);
        }
        return answer;
    }
}
