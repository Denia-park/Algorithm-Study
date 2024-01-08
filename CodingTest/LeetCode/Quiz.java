package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.rangeSumBST(null, 7, 15));
    }
}

class Solution {
    int gLow;
    int gHigh;

    public int rangeSumBST(final TreeNode root, final int low, final int high) {
        gLow = low;
        gHigh = high;

        return recursiveSum(root);
    }

    public int recursiveSum(final TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        final int val = node.val;

        if (gLow <= val && val <= gHigh) {
            sum += val;
        }

        return sum + recursiveSum(node.left) + recursiveSum(node.right);
    }
}

//Definition for a binary tree node.
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
