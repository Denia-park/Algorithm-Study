package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println("1 : " + solution.leafSimilar(null, null));
    }
}

class Solution {
    public boolean leafSimilar(final TreeNode root1, final TreeNode root2) {
        final List<Integer> leaftList1 = new ArrayList<>();
        final List<Integer> leaftList2 = new ArrayList<>();

        getLeafList(root1, leaftList1);
        getLeafList(root2, leaftList2);

        if (leaftList1.size() != leaftList2.size()) {
            return false;
        }

        for (int i = 0; i < leaftList1.size(); i++) {
            if (leaftList1.get(i) != leaftList2.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void getLeafList(final TreeNode root, final List<Integer> leaftList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaftList.add(root.val);
        }

        getLeafList(root.left, leaftList);
        getLeafList(root.right, leaftList);
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
