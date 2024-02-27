package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.isSameTree(
//                new int[]{2, 3, 6}
//        ));
//        System.out.println(solution.isSameTree(
//                new int[]{3, 9, 5}
//        ));
//        System.out.println(solution.isSameTree(
//                new int[]{4, 3, 12, 8}
//        ));
    }
}

class Solution {
    int answer;

    public int diameterOfBinaryTree(final TreeNode root) {
        answer = -1;
        checkHeight(root);

        return answer;
    }

    private int checkHeight(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int leftVal = checkHeight(root.left);
        final int rightVal = checkHeight(root.right);
        answer = Math.max(answer, leftVal + rightVal);

        return Math.max(leftVal, rightVal) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(final int val) {
        this.val = val;
    }

    TreeNode(final int val, final TreeNode left, final TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
