import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<String> solution(int studentNum, int[][] studentDiff) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= studentNum; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[studentNum + 1];

        for (int i = 0; i < studentDiff.length; i++) {
            int[] eachGraph = studentDiff[i];
            int small = eachGraph[0];
            int big = eachGraph[1];
            graph.get(small).add(big);
            indegree[big]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= studentNum; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int curStu = queue.poll();

            result.add(String.valueOf(curStu));
            List<Integer> tempList = graph.get(curStu);

            for (int nextStu : tempList) {
                if (indegree[nextStu] > 0) {
                    indegree[nextStu]--;

                    if (indegree[nextStu] == 0) {
                        queue.offer(nextStu);
                    }
                }
            }
        }

        return result;
    }
}
