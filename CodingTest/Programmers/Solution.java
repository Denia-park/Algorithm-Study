package CodingTest.Programmers;

/*
아이디어
1. Map에 List를 넣어서 해당 경로에서 도착할 수 있는 모든 경로 정리
2. ICN 부터 시작해서 모든 경로를 탐색
3. 도착할때마다 List에 저장 후 마지막에 변환

시간복잡도
N번 돌면 끝나지 않나 ?

자료구조

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private String START_DEPARTURE = "ICN";
    private List<String> answer = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();
    private Map<String, Integer> haveToVisitMap = new HashMap<>();

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        map = new HashMap<>();
        haveToVisitMap = new HashMap<>();

        for (String[] ticket : tickets) {
            final String departure = ticket[0];
            final String arrival = ticket[1];

            //검색해서 List가 존재하면 거기에 추가, 없으면 새로 생성
            final List<String> arrivalList = map.getOrDefault(departure, new ArrayList<>());
            arrivalList.add(arrival);
            map.put(departure, arrivalList);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            haveToVisitMap.put(entry.getKey(), 0);
            entry.getValue().sort(null);
        }

        dfs(START_DEPARTURE);

        final String[] array = answer.toArray(new String[answer.size()]);
        return array;
    }

    private void dfs(String departure) {
        answer.add(departure);
        final List<String> arrivals = map.get(departure);

        if (arrivals == null) {
            return;
        }

        for (int idx = 0; idx < arrivals.size(); idx++) {
            final int checkIdx = haveToVisitMap.get(departure);
            if (idx < checkIdx) {
                continue;
            }

            haveToVisitMap.put(departure, checkIdx + 1);

            dfs(arrivals.get(idx));
        }
    }
}
