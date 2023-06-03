package CodingTest.Baekjoon;

//최소 스패닝 트리 1197

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int vNum = Integer.parseInt(split[0]);
        int eNum = Integer.parseInt(split[1]);

        String[] edges = new String[eNum];

        for (int i = 0; i < eNum; i++) {
            edges[i] = br.readLine();
        }

        sol.solution(vNum, edges);
    }
}

/*
아이디어
최소 스패닝 트리
- 크루스칼
- 프림
    - 한 노드 선택
    - 노드의 모든 Edge Heap 넣기
    - 연결된 노드가 방문한적 있는지 체크
    - 없으면 가중치 추가, 방문 체크
    - 해당 노드에서 다시 1번부터 수행 -> 방문한 노드는 제외하자.

- 출력
최소 가중치

시간복잡도
O(ELogE)

자료구조
출력값은 제한조건에 의해 int
방문 처리 필요 int[]
 */

class BjSolution {
    public void solution(int vNum, String[] edges) {
        int ans = 0;
        boolean[] visited = new boolean[vNum + 1];

        //인접 리스트 만들기
        List<List<int[]>> map = new ArrayList<>();

        //계산을 편리하기 위해 0번째도 같이 넣기
        for (int i = 0; i < vNum + 1; i++) {
            map.add(new ArrayList<>());
        }

        for (String edge : edges) {
            String[] tempSplit = edge.split(" ");
            int v1 = Integer.parseInt(tempSplit[0]);
            int v2 = Integer.parseInt(tempSplit[1]);
            int weight = Integer.parseInt(tempSplit[2]);

            map.get(v1).add(new int[]{v2, weight});
            map.get(v2).add(new int[]{v1, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        //시작 노드, 노드 Num, 노드 Weight
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();

            int curNodeNum = curNode[0];
            int curWeight = curNode[1];

            if (visited[curNodeNum]) continue;
            visited[curNodeNum] = true;
            ans += curWeight;

            for (int[] node : map.get(curNodeNum)) {
                int nextNodeNum = node[0];
                int nextNodeWeight = node[1];
                if (visited[nextNodeNum]) continue;

                pq.add(new int[]{nextNodeNum, nextNodeWeight});
            }
        }

        System.out.println(ans);
    }
}

//        *StringTokenizer*
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        int stNum = Integer.parseInt(st.nextToken());
//        int testValue = Integer.parseInt(br.readLine());

//        *BufferedReader*
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCaseNum = Integer.parseInt(br.readLine());
//        String[] testCase = new String[testCaseNum];
//        for (int i = 0; i < testCaseNum; i++) {
//            testCase[i] = br.readLine();
//        }
