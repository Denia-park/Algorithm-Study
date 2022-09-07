package com.company;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int peopleNum, String[] words) {
        //중복을 체크할 HashMap 사용
        Map<String, Integer> answerMap = new HashMap<>();
        //현재가 몇번째인지 확인할 변수
        int forIndex = 0;
        //마지막 글자를 저장할 변수
        char lastChar = '\0';

        //for문을 돌면서 words 를 확인
        for (forIndex = 0; forIndex < words.length; forIndex++) {
            //lasgChar 초기화를 \0 으로 했기 때문에
            // \0이 아닌 경우 + lastChar 가 현재 단어의 맨 앞 글자와 다른 경우 for문 종료
            if(lastChar != '\0' && words[forIndex].charAt(0) != lastChar) break;

            // HashMap 에 저장된 해당 단어의 수가 2번째로 나오는 경우
            // 해당 단어는 중복되었으므로 for문 종료
            int wordCount = answerMap.getOrDefault(words[forIndex], 0) + 1;
            if(wordCount == 2) break;

            // 위의 2개의 조건에 모두 해당하지 않는 경우 나온 단어를 HashMap 에 저장 하고 단어 수를 1 올린다.
            answerMap.put(words[forIndex], wordCount);
            //단어에 대한 확인이 끌날때마다 lastChar 을 업데이트 해준다.
            lastChar = words[forIndex].charAt(words[forIndex].length() - 1);
        }

        // 정상적으로 for문이 종료되었으면 forIndex 가 words.length 가 나오므로
            // {0,0} 을 리턴
            // 정상적으로 for문이 종료되지 않았다면 forIndex 값을 이용하여 순서와 몇번째 턴인지를 확인한다.
        return forIndex == words.length ? new int[]{0, 0} : new int[]{forIndex % peopleNum + 1, forIndex / peopleNum + 1};
    }
}
