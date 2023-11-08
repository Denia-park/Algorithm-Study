package CodingTest.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{0, 1}));
        System.out.println(solution.permute(new int[]{1}));
    }
}

class Solution {
    private List<List<Integer>> answer;
    private List<Wrapper> nums;

    public List<List<Integer>> permute(int[] params) {
        answer = new ArrayList<>();
        nums = new ArrayList<>();

        for (int param : params) {
            nums.add(new Wrapper(param, false));
        }

        final Deque<Wrapper> dq = new ArrayDeque<>();
        dfs(dq);

        return answer;
    }

    private void dfs(final Deque<Wrapper> dq) {
        if (dq.size() == nums.size()) {
            List<Integer> list = new ArrayList<>();
            for (Wrapper wrapper : dq) {
                list.add(wrapper.value);
            }
            answer.add(list);
            return;
        }

        for (Wrapper wrapper : nums) {
            if (wrapper.visited) {
                continue;
            }

            wrapper.visited = true;
            dq.offer(wrapper);
            dfs(dq);
            dq.pollLast();
            wrapper.visited = false;
        }
    }
}

class Wrapper {
    int value;
    boolean visited;

    public Wrapper(final int value, final boolean visited) {
        this.value = value;
        this.visited = visited;
    }
}
