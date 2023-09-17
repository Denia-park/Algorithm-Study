package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeDuplicates(new int[]{1}));
        System.out.println(solution.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(solution.removeDuplicates(new int[]{1, 2, 3}));
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}

class Solution {
    //0번째 1, 1번째 1 이면 -> insertIndex 유지, diffValue 변경
    //0번째 1, 1번째 2 이면 -> insertIndex ++, diffValue 변경
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1; //처음에 0번째는 고정이므로, 첫번째부터 시작

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }

        return insertIndex;
    }
}
