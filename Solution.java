import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> answer;
    int[] gTable;
    boolean[] visited;

    public void solution(int size, int[] table) {
        answer = new HashSet<>();
        gTable = table;

        for (int i = 1; i <= size; i++) {
            visited = new boolean[size + 1];
            getParent(i, i);
        }

        System.out.println(answer.size());
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private void getParent(int origin, int idx) {
        if (visited[idx]) {
            if (origin == idx) {
                answer.add(origin);
            }

            return;
        }

        visited[idx] = true;

        int parent = gTable[idx];
        getParent(origin, parent);
    }
}
