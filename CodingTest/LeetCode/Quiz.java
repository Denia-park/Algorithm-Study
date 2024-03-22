package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

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
    public boolean isPalindrome(final ListNode head) {
        final List<Integer> save = new ArrayList<>();

        ListNode cur = head;
        while (cur != null) {
            save.add(cur.val);
            cur = cur.next;
        }

        final int len = save.size();

        for (int i = 0; i < len / 2; i++) {
            final int st = save.get(i);
            final int ed = save.get(len - 1 - i);

            if (st != ed) {
                return false;
            }
        }

        return true;
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
