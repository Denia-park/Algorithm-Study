package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }
}

class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> answer;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        answer = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        //조합을 써서 모든 경우의 수를 구하면 될까 ?
        int curIndex = 0;
        int sum = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dfs(curIndex, sum, dq);

        return answer;
    }

    private void dfs(final int curIndex, final int sum, final Deque<Integer> dq) {
        if (sum == target) {
            answer.add(new ArrayList<>(dq));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = curIndex; i < candidates.length; i++) {
            dq.add(candidates[i]);
            dfs(i, sum + candidates[i], dq);
            dq.removeLast();
        }
    }
}
