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
    public boolean isSameTree(final TreeNode p, final TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
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
