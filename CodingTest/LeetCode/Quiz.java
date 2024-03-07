package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.middleNode("ca"));
    }
}

class Solution {
    public ListNode middleNode(final ListNode head) {
        final List<ListNode> save = new ArrayList<>();

        ListNode cur = head;

        while (cur != null) {
            save.add(cur);
            cur = cur.next;
        }

        return save.get(save.size() / 2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(final int x) {
        val = x;
        next = null;
    }
}
