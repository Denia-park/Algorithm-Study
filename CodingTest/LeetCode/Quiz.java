package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(solution.removeNthFromEnd(
//                new int[]{1, 2, 3, 4, 5}, 2
//        ));
//        System.out.println(solution.removeNthFromEnd(
//                new int[]{1}, 1
//        ));
//        System.out.println(solution.removeNthFromEnd(
//                new int[]{1, 2}, 1
//        ));
    }
}

class Solution {
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        final List<ListNode> nodes = new ArrayList<>();

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
            size++;
        }

        final int preIdx = size - n - 1;
        if (preIdx < 0) {
            return head.next;
        }
        final ListNode preNode = nodes.get(preIdx);

        final ListNode deleteNode = nodes.get(size - n);

        preNode.next = deleteNode.next;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(final int val) {
        this.val = val;
    }

    ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }
}
