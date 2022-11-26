import java.util.*;

// 알고리즘 검색 해봄
//https://bbeomgeun.tistory.com/121
class Solution {
    int answer;
    int endStation;
    boolean[] isVisitedLine;
    int[] isVisitedStation = new int[1000001];
    List<String[]> gSubwaySplits;

    public int solution(String[] subway, int start, int end) {
        answer = Integer.MAX_VALUE;
        endStation = end;
        isVisitedLine = new boolean[subway.length];
        Arrays.fill(isVisitedStation, Integer.MAX_VALUE);

        List<String[]> subwaySplits = new ArrayList<>();
        for (String str : subway) {
            String[] stations = str.split(" ");
            subwaySplits.add(stations);
        }
        gSubwaySplits = subwaySplits;

        Map<String, List<String>> stationLineInfos = new HashMap<>();

        int stationIdx = 0;
        for (String[] subwaySplit : subwaySplits) {
            for (String stationName : subwaySplit) {
                List<String> linesOfStation = stationLineInfos.getOrDefault(stationName, new ArrayList<>());
                linesOfStation.add(String.valueOf(stationIdx));
                stationLineInfos.put(stationName, linesOfStation);
            }
            stationIdx++;
        }

        bfs(start, stationLineInfos);

        return isVisitedStation[end];
    }

    private void bfs(int startStaion, Map<String, List<String>> map) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startStaion);
        isVisitedStation[startStaion] = -1;

        while (!que.isEmpty()) {
            int curStaion = que.poll();
            List<String> subwayLines = map.get(String.valueOf(curStaion));

            for (String subwayLine : subwayLines) {
                if (isVisitedLine[Integer.parseInt(subwayLine)]) {
                    continue;
                }

                isVisitedLine[Integer.parseInt(subwayLine)] = true;

                String[] stations = gSubwaySplits.get(Integer.parseInt(subwayLine));
                for (String nextStation : stations) {
                    int nextStationInt = Integer.parseInt(nextStation);
                    if (isVisitedStation[nextStationInt] == Integer.MAX_VALUE) {
                        isVisitedStation[nextStationInt] = isVisitedStation[curStaion] + 1;
                        que.add(nextStationInt);
                    }
                }
            }
        }
    }
}
