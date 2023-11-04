package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2);
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1) == 0);
    }
}

class Solution {
    private int[] nums;
    private int target;
    private int answer;

    public int threeSumClosest(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        answer = (int) Math.pow(10, 7);

        //dfs를 통해 모든 조합을 구해야 할 것 같다.
        int startIdx = 0;
        int sumCount = 0;
        dfs(startIdx, sumCount, 0);

        return answer;
    }

    private void dfs(final int startIdx, final int sumCount, final int sum) {
        if (sumCount >= 3) {
            answer = Math.abs(sum - target) < Math.abs(answer - target) ? sum : answer;
            return;
        }

        for (int curIdx = startIdx; curIdx < nums.length; curIdx++) {
            int curValue = nums[curIdx];

            dfs(curIdx + 1, sumCount + 1, sum + curValue);
        }
    }
}
