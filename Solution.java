package com.company;

import java.util.*;

// https://fbtmdwhd33.tistory.com/249 참고

class Solution {
    String dfsString;
    Set<String> tempGlobalSet;
    boolean[] isVisited;

    Map<String, Integer> answerMap;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();

        // 1. 각 문자열을 오름차순 정렬.
        for(int i =0;i<orders.length;i++){
            // 2. 각 문자열을 문자형 배열로 변환.
            char[] charArr = orders[i].toCharArray();
            // 3. 해당 문자형 배열을 정렬.
            Arrays.sort(charArr);
            // 4. 정렬된 문자형 배열을 문자열로 변환해 저장.
            orders[i] = String.valueOf(charArr);
        }

        // 5. course의 길이만큼 반복하여 필요한 조합을 구함.
        for (int courseNum : course) {
            // 6. HashMap으로 조합의 수를 카운팅.
            answerMap = new HashMap<String, Integer>();

            // 7. course의 경우에 따라 구한 조합들 중 가장 많이 주문된 횟수를 저장.
            int max = Integer.MIN_VALUE;

            // 8. 각 사람들의 조합을 구하기 위해 탐색.
            for (String order : orders) {
                dfsString = order;
                StringBuilder sb = new StringBuilder();
                dfs(sb,0,courseNum);
            }

            for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            if(max == 1) continue;
            for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        answer.sort(null);

        return answer.toArray(new String[0]);
    }

    // 13. 조합을 구하는 메소드 (한 사람의 메뉴구성, 조합을 구할 StringBuilder, 조합을 위한 idx, 코스요리 개수에 따른 종료조건을 위한 cnt와 n)
    public void dfs(StringBuilder curStr, int idx, int strLenLimit) {
        // 14. 각 코스요리의 개수만큼 조합이 되면,
        if (curStr.length() == strLenLimit) {
            // 15. map에 해당 조합을 삽입 및 카운팅.
            answerMap.put(curStr.toString(), answerMap.getOrDefault(curStr.toString(), 0) + 1);
            return;
        }

        // 16. idx부터 시작함으로써 조합을 구할 수 있다.
        for (int i = idx; i < dfsString.length(); i++) {
            // 18. 재귀호출.
            curStr.append(dfsString.charAt(i));
            dfs(curStr, i + 1, strLenLimit);
            curStr.deleteCharAt(curStr.length()-1);
        }
    }
}

