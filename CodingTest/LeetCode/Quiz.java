package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<Integer> inorderTraversal(final TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        final List<Integer> answers = new ArrayList<>();

        //왼쪽 탐색
        answers.addAll(inorderTraversal(root.left));

        //값 표현
        answers.add(root.val);

        //오른쪽 탐색
        answers.addAll(inorderTraversal(root.right));

        return answers;
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
