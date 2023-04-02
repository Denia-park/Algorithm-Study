package CodingTest.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//23년 4월 2일 오후 7시 35분
//47분 걸림

//정답 참고
//https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-10971-%EC%99%B8%ED%8C%90%EC%9B%90-%EC%88%9C%ED%9A%8C-2-JAVA

public class Main {
    public static void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        int caseNum = Integer.parseInt(l1);
        String[] iArr = new String[caseNum];
        for (int i = 0; i < caseNum; i++) {
            iArr[i] = br.readLine();
        }

        sol.solution(iArr);
    }
}

class BjSolution {
    private int ans;
    private int totalNodeNum;
    private boolean[] visited;
    private List<List<Integer>> map;

    public void solution(String[] iArr) {
        ans = Integer.MAX_VALUE;
        totalNodeNum = iArr.length;
        visited = new boolean[iArr.length];

        map = new ArrayList<>();

        for (String str : iArr) {
            String[] s = str.split(" ");
            List<Integer> l = new ArrayList<>();
            for (String s1 : s) {
                l.add(Integer.parseInt(s1));
            }
            map.add(l);
        }

        // 외판원 순회 문제는 어디서 시작을 해도 답은 동일하므로
        // 나는 0번 노드에서 무조건 시작하는걸로 한다.
        visited[0] = true;
        dfs(0, 0, 0, 0);

        System.out.println(ans);
    }

    private void dfs(int startNode, int curNode, int distance, int count) {
        if (count == totalNodeNum - 1) {
            distance += map.get(curNode).get(startNode);
            ans = Math.min(ans, distance);
            return;
        }

        for (int nextIdx = 1; nextIdx < totalNodeNum; nextIdx++) {
            if (visited[nextIdx]) continue;

            visited[nextIdx] = true;
            int nextDistance = map.get(curNode).get(nextIdx);
            dfs(startNode, nextIdx, distance + nextDistance, count + 1);
            visited[nextIdx] = false;
        }
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
