package CodingTest.Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
탐욕법(Greedy) - 단속카메라

아이디어
-그리디
-routes의 각각의 데이터를 모두 오름차순으로 정렬 (0번째 원소, 1번째 원소의 크기를 보장 못하므로)
-routes를 끝 값 기준으로 오름차순으로 정렬
-list를 돌면서 현재 끝 값기준으로 시작지점이 끝 값보다 이전이면 끝값에 카메라를 둘 경우 해당 차량들이 지나간다고 보장이 가능하다.

시간복잡도
O(NLgN) + O(N)

자료형
int[] 사용 - 0:시작 1:끝 인데 보장을 못하니까 정렬이 필요함
*/
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        List<Route> routeList = new ArrayList<>();
        for (int[] route : routes) {
            int end = Math.max(route[0], route[1]);
            int start = Math.min(route[0], route[1]);

            routeList.add(new Route(start, end));
        }
        routeList.sort(Comparator.comparingInt(o -> o.end));

        answer = 1;
        Route standard = routeList.get(0);
        for (int idx = 1; idx < routes.length; idx++) {
            Route newRoute = routeList.get(idx);

            if (standard.end >= newRoute.start) continue;

            standard = newRoute;
            answer++;
        }

        return answer;
    }
}

class Route {
    int start;
    int end;

    public Route(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
