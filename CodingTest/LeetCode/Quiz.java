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
        final String strP = inorder(p);
        final String strQ = inorder(q);

        return strP.equals(strQ);
    }

    private String inorder(final TreeNode p) {
        if (p == null) {
            return "";
        }

        final String sb = "l:" + inorder(p.left) +
                "c:" + p.val + "," +
                "r:" + inorder(p.right);

        return sb;
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
