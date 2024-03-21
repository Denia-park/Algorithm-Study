package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

//        System.out.println(
//                solution.mergeInBetween(
//                        new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
//                        2
//                )
//        );
    }
}

class Solution {
    public ListNode reverseList(final ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode save = null;

        while (cur != null) {
            final ListNode tempNext = cur.next;
            cur.next = save;
            save = cur;
            cur = tempNext;
        }

        return save;
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
