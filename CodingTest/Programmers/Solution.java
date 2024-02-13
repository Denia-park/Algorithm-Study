package CodingTest.Programmers;

import java.util.Arrays;

//https://github.com/encrypted-def/kakao-blind-recruitment/blob/master/2022-blind/Q5.java
class Solution {
    int[] l = new int[20]; //왼쪽 자식
    int[] r = new int[20]; //오른쪽 자식
    int[] val = new int[20]; //양/늑대 값
    int n;
    int ans = 1;
    int[] vis = new int[1 << 17];

    public int solution(final int[] info, final int[][] edges) {
        n = info.length;
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        System.arraycopy(info, 0, val, 0, n);
        for (final int[] edge : edges) {
            final int a = edge[0]; //부모
            final int b = edge[1]; //자식

            if (l[a] == -1) l[a] = b;
            else r[a] = b;
        }

        solve(1); //0번 노드만 포함된 상태에서 dfs 시작

        return ans;
    }

    void solve(final int state) {
        //방문 했으면 다시 방문 안함
        if (vis[state] == 1) return;
        vis[state] = 1;

        //wolf : 늑대의 수, num : 전체 정점의 수
        int wolf = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) != 0) {
                num++;
                wolf += val[i];
            }
        }

        //만약 늑대가 절반 이상이면 방문 못함 종료
        if (2 * wolf >= num) return;
        //현재 state의 양의 수가 ans보다 크면 ans 갱신
        final int curSheep = num - wolf;
        ans = Math.max(ans, curSheep);

        //다음을 확인한다.
        for (int i = 0; i < n; i++) {
            //해당 지점은 아직 방문 안했으니 패스 (해당 지점 이후로는 못 넘어가므로)
            if ((state & (1 << i)) == 0) continue;

            //현재 i번째 노드에서 left가 있으면 방문 (자식 노드를 방문해야 하므로, l[i])
            if (l[i] != -1) {
                solve(state | (1 << l[i]));
            }
            //현재 i번째 노드에서 right가 있으면 방문 (자식 노드를 방문해야 하므로, r[i])
            if (r[i] != -1) {
                solve(state | (1 << r[i]));
            }
        }
    }
}
