import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    int[] gScvs;
    int gScvNum;
    boolean[] visited;
    List<List<Integer>> permutations;
    int answer;

    int[] attackValues = {9, 3, 1};

    public long solution(int scvNum, int[] scvs) {
        answer = Integer.MAX_VALUE;
        permutations = new ArrayList<>();
        visited = new boolean[scvNum];
        gScvNum = scvNum;
        gScvs = scvs;

        Deque<Integer> dq = new LinkedList<>();

        getPermutations(dq);

        int[] tempScvs = new int[gScvNum];
        System.arraycopy(scvs, 0, tempScvs, 0, gScvNum);

        calculateCount(tempScvs, 0);

        return answer;
    }

    private void calculateCount(int[] scvs, int count) {
        if (count > answer) {
            return;
        }

        if (isAllHpZero(scvs)) {
            answer = count;
            return;
        }

        for (List<Integer> permutation : permutations) {
            int[] tempScvs = new int[gScvNum];
            System.arraycopy(scvs, 0, tempScvs, 0, gScvNum);

            for (int j = 0; j < permutation.size(); j++) {
                if (tempScvs[permutation.get(j)] < 0) {
                    continue;
                }

                tempScvs[permutation.get(j)] -= attackValues[j];
            }

            calculateCount(tempScvs, count + 1);
        }
    }

    private boolean isAllHpZero(int[] scvs) {
        for (int scv : scvs) {
            if (scv > 0) {
                return false;
            }
        }

        return true;
    }

    private void getPermutations(Deque<Integer> list) {
        if (list.size() == gScvNum) {
            List<Integer> tempList = new ArrayList<>(list);
            permutations.add(tempList);
            return;
        }

        for (int i = 0; i < gScvNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.addLast(i);
                getPermutations(list);
                list.pollLast();
                visited[i] = false;
            }
        }
    }
}
