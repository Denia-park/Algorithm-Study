package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
//        System.out.println(solution.tree2str("52"));
//        System.out.println(solution.tree2str("4206"));
//        System.out.println(solution.tree2str("35427"));
//        System.out.println(solution.tree2str("7542351161"));
    }
}

class Solution {
    public String tree2str(final TreeNode root) {
        if (root == null) {
            return "";
        }

        //재귀를 써야할 것 같다.
        final StringBuilder sb = new StringBuilder();

        //val을 표시한다.
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            return sb.toString();
        }

        //왼쪽부터 탐색한다
        if (root.left != null) {
            sb.append("(");
            sb.append(tree2str(root.left));
            sb.append(")");
        }

        //오른쪽을 탐색한다.
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }

            sb.append("(");
            sb.append(tree2str(root.right));
            sb.append(")");
        }

        return sb.toString();
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
