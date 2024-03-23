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
    public void reorderList(ListNode head) {
        //reverse List
        ListNode save = null;
        ListNode curReverse = head;
        ListNode normal = new ListNode(head.val);
        ListNode curNormal = normal;

        int length = 0;
        while (curReverse != null) {
            final ListNode tempNext = curReverse.next;
            curReverse.next = save;
            save = curReverse;
            curReverse = tempNext;

            if (tempNext != null) {
                curNormal.next = new ListNode(tempNext.val);
            } else {
                curNormal.next = null;
            }
            curNormal = curNormal.next;
            length++;
        }

        ListNode reverse = save;

        System.out.println("length");
        System.out.println(length);
        System.out.println("normal");
        print(normal);
        System.out.println("reverse");
        print(reverse);

        int count = 1;
        final ListNode answer = normal;
        ListNode curAnswer = answer;
        normal = normal.next;
        while (count != length) {
            if (count % 2 == 0) {
                curAnswer.next = new ListNode(normal.val);
                normal = normal.next;
            } else {
                curAnswer.next = new ListNode(reverse.val);
                reverse = reverse.next;
            }

            curAnswer = curAnswer.next;
            count++;
        }

        head = answer;
    }

    private void print(final ListNode normal) {
        ListNode temp = normal;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
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
