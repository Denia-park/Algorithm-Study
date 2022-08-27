package com.company;

import java.util.*;

// https://fbtmdwhd33.tistory.com/249 참고

class Solution {
    //dfs 에서 사용할 String을 전역변수로 설정
    String dfsString;

    //dfs에서 사용할 Map 설정
    Map<String, Integer> answerMap;

    public String[] solution(String[] orders, int[] course) {
        //필요한 만큼만 추가해야 하므로 answer를 List로 생성
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
                //order가 courseNum 보다 작을 경우 계산하지 않음
                if(order.length() < courseNum) continue;
                //dfsString은 고객 1명이 주문한 order로 설정
                dfsString = order;
                //빠른 속도를 위해서 StringBuilder 를 설정
                StringBuilder sb = new StringBuilder();
                //StringBuilder 와 조합시에 계산을 도와줄 index , 메뉴 개수 제한을 알려줄 courseNum을 dfs의 매개변수로 할당
                dfs(sb,0,courseNum);
            }

            //Math.max 를 이용하여 기존의 max 와 answerMap Value 중에 제일 큰 값을 비교해서 max 를 구한다.
            //max는 아래에서 answer List에 추가할때 기준이 된다.
            for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            //고객이 1명만 먹은 메뉴는 추가하지 않는다.
            if(max == 1) continue;

            //entry를 돌면서 max보다 큰 값을 가진 메뉴는 answer List에 추가한다.
            for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
                if (entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }

        //course 배열을 돌면서 구한 answer List를 오름차순으로 정렬
        answer.sort(null);

        //List 를 Array 로 변환
        return answer.toArray(new String[0]);
    }

    // 13. 조합을 구하는 메소드 (curStr : 현재 메뉴, 조합을 계산하기 위한 index, 코스요리 개수에 따른 종료조건을 위한 strLenLimit)
    public void dfs(StringBuilder curStr, int idx, int strLenLimit) {
        // 14. 코스요리의 조합의 개수가 종료조건에 해당하면
        // map에 추가하고 종료 (map에 추가할때 기존의 값에 + 1 을 적용)
        if (curStr.length() == strLenLimit) {
            // 15. map에 해당 조합을 삽입 및 카운팅.
            answerMap.put(curStr.toString(), answerMap.getOrDefault(curStr.toString(), 0) + 1);
            return;
        }

        // 16. idx부터 시작함으로써 조합을 구할 수 있다.
        for (int i = idx; i < dfsString.length(); i++) {
            //StringBuilder 를 사용했으므로 1글자를 추가
            curStr.append(dfsString.charAt(i));
            // 18. 재귀호출.
            dfs(curStr, i + 1, strLenLimit);
            //StringBuilder 를 사용했으므로 1글자를 제거 (마지막 글자를 제거해야 하므로 curStr.length() -1 을 적용함)
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}

