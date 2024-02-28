package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.findBottomLeftValue(
//        ));
//        System.out.println(solution.findBottomLeftValue(
//        ));
    }
}

class Solution {

    private int depth;
    private int answer;

    public int findBottomLeftValue(final TreeNode root) {
        //preorder를 통해서 탐색을 하고, 새로운 depth를 갈 때마다 answer를 업데이트
        depth = -1;
        answer = 0;

        checkLeftByInorder(root, 0);

        return answer;
    }

    private void checkLeftByInorder(final TreeNode root, final int curDepth) {
        if (root == null) {
            return;
        }

        if (curDepth > depth) {
            depth = curDepth;
            answer = root.val;
        }

        checkLeftByInorder(root.left, curDepth + 1);
        checkLeftByInorder(root.right, curDepth + 1);
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
