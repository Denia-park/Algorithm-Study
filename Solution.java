import java.util.ArrayDeque;
import java.util.Deque;

//깊이에 해당하면 종료
//깊이 도달할때마다 print문
class Solution {
    int maxNum;
    int numCountLimit;

    public void solution(int N, int M) {
        maxNum = N;
        numCountLimit = M;
        Deque<Integer> queue = new ArrayDeque<>();
        dfs(queue, 1);
    }

    private void dfs(Deque<Integer> queue, int startNum) {
        if (queue.size() == numCountLimit) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : queue) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = startNum; i <= maxNum; i++) {
            queue.offerLast(i);
            dfs(queue, i);
            queue.pollLast();
        }
    }
}
