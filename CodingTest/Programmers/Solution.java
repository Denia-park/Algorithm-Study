package CodingTest.Programmers;

//2021 KAKAO BLIND RECRUITMENT
//합승 택시 요금 [LV.3]

/*
1. 아이디어
- 플루이드 워셜로 전체 거리를 구한다.
- 합승을 어디까지 할지 모든 노드를 기준으로 한번 돌고 합승한 거리에서부터 나머지 A,B까지의 값을 구한다.
- 최소값을 return

2. 시간복잡도
플루이드 워셜 : O(V^3) -> 200 ^ 3 -> 800만
플루이드 사용후 모든 노드 다시 탐색 : O(V)

충분하다.

3. 자료구조
- 2차원 int 배열로 모든 거리를 저장.
- 요금 f는 10만 이하 자연수 -> 200번 더해도 2억이므로 int 써도 된다.
*/

import java.util.Arrays;

class Solution {
    public int solution(int nodeNum, int startNode, int aHome, int bHome, int[][] fares) {
        //graph 만들기 - 0번 Idx 사용 안함
        int[][] graph = new int[nodeNum + 1][nodeNum + 1];
        //모든 거리는 무제한으로 넣어주기.
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        //자기 자신은 거리가 0
        for (int i = 0; i <= nodeNum; i++) {
            graph[i][i] = 0;
        }
        //fares 기반으로 거리 내용 업데이트
        for (int[] fare : fares) {
            int node1 = fare[0];
            int node2 = fare[1];
            int cost = fare[2];

            graph[node1][node2] = cost;
            graph[node2][node1] = cost;
        }

        //floyd-warshall
        floayWarhall(nodeNum, graph);

        //합승할 Node를 한번씩 돌면서 거기서 각 집으로 가는 거리 구해서 최소값 구하기.
        int minCost = Integer.MAX_VALUE;

        for (int shareNode = 1; shareNode <= nodeNum; shareNode++) {
            int shareCost = graph[startNode][shareNode];
            int aCost = graph[shareNode][aHome];
            int bCost = graph[shareNode][bHome];

            int totalCost = shareCost + aCost + bCost;

            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    private void floayWarhall(int nodeNum, int[][] graph) {
        for (int mid = 1; mid <= nodeNum; mid++) {
            for (int start = 1; start <= nodeNum; start++) {
                for (int end = 1; end <= nodeNum; end++) {
                    int originCost = graph[start][end];

                    if (graph[start][mid] == Integer.MAX_VALUE || graph[mid][end] == Integer.MAX_VALUE) continue;

                    int newCost = graph[start][mid] + graph[mid][end];

                    if (originCost <= newCost) continue;

                    graph[start][end] = newCost;
                }
            }
        }
    }
}
